package com.nlwjava.certicationnwlavilarafael.modules.studends.useCases;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlwjava.certicationnwlavilarafael.modules.questions.entities.QuestionEntity;
import com.nlwjava.certicationnwlavilarafael.modules.questions.repositories.QuestionRepository;
import com.nlwjava.certicationnwlavilarafael.modules.studends.dto.StudentCertificationAnswerDTO;
import com.nlwjava.certicationnwlavilarafael.modules.studends.dto.VerifyHasCertificationDTO;
import com.nlwjava.certicationnwlavilarafael.modules.studends.entities.AnswersCertificationsEntity;
import com.nlwjava.certicationnwlavilarafael.modules.studends.entities.CertificationStudentEntity;
import com.nlwjava.certicationnwlavilarafael.modules.studends.entities.StudentEntity;
import com.nlwjava.certicationnwlavilarafael.modules.studends.repositories.CertificationStudentRepository;
import com.nlwjava.certicationnwlavilarafael.modules.studends.repositories.StudentRepository;

@Service
public class StudentCertificationAnswersUseCase {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CertificationStudentRepository certificationStudentRepository;

    @Autowired
    private VerifyHasCertificationUseCase verifyHasCertificationUseCase;

    @SuppressWarnings("null")
    public CertificationStudentEntity execute(StudentCertificationAnswerDTO dto) throws Exception {

        var hasCertification = verifyHasCertificationUseCase
                .execute(new VerifyHasCertificationDTO(dto.getEmail(), dto.getTechnology()));
        if (hasCertification) {
            throw new Exception("you already have a certifcation");
        }
        List<AnswersCertificationsEntity> answersCertifications = new ArrayList<>();
        List<QuestionEntity> questionsEntity = questionRepository.findByTechnology(dto.getTechnology());
        AtomicInteger correctAnswers = new AtomicInteger(0);
        dto.getQuestionsAnswers().stream().forEach(questionAnswer -> {
            var question = questionsEntity.stream().filter(q -> q.getId().equals(questionAnswer.getQuestionID()))
                    .findFirst().get();

            var findCorrectAlternative = question.getAlternatives().stream()
                    .filter(alternative -> alternative.isCorrect()).findFirst().get();

            if (findCorrectAlternative.getId().equals(questionAnswer.getAlternativeID())) {
                questionAnswer.setCorrect(true);
                correctAnswers.incrementAndGet();
            } else {
                questionAnswer.setCorrect(false);
            }
            var answerCertificaitonEntity = AnswersCertificationsEntity.builder()
                    .answerID(questionAnswer.getAlternativeID()).questionID(questionAnswer
                            .getQuestionID())
                    .isCorrect(questionAnswer.isCorrect()).build();
            answersCertifications.add(answerCertificaitonEntity);
        });
        UUID studentID;
        var student = studentRepository.findByEmail(dto.getEmail());
        if (student.isEmpty()) {
            var studentCreated = StudentEntity.builder().email(dto.getEmail()).build();
            studentCreated = studentRepository.save(studentCreated);
            studentID = studentCreated.getId();
        } else {
            studentID = student.get().getId();
        }

        CertificationStudentEntity certificationStudentEntity = CertificationStudentEntity.builder()
                .technology(dto.getTechnology()).StudentID(studentID).grade(correctAnswers.get()).build();

        var certificationStudentCreated = certificationStudentRepository.save(certificationStudentEntity);
        answersCertifications.stream().forEach(answersCertification -> {
            answersCertification.setCertificationId(certificationStudentEntity.getId());
            answersCertification.setCertificationStudentEntity(certificationStudentEntity);
        });
        certificationStudentEntity.setAnswersCertificationsEntities(answersCertifications);

        certificationStudentRepository.save(certificationStudentEntity);

        return certificationStudentCreated;
    }
}
