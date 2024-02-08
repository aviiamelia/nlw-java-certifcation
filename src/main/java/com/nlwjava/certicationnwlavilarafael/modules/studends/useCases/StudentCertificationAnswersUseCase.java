package com.nlwjava.certicationnwlavilarafael.modules.studends.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlwjava.certicationnwlavilarafael.modules.questions.entities.QuestionEntity;
import com.nlwjava.certicationnwlavilarafael.modules.questions.repositories.QuestionRepository;
import com.nlwjava.certicationnwlavilarafael.modules.studends.dto.StudentCertificationAnswerDTO;

@Service
public class StudentCertificationAnswersUseCase {

    @Autowired
    private QuestionRepository questionRepository;

    public StudentCertificationAnswerDTO execute(StudentCertificationAnswerDTO dto) {

        List<QuestionEntity> questionsEntity = questionRepository.findByTechnology(dto.getTechnology());
        dto.getQuestionsAnswers().stream().forEach(questionAnswer -> {
            var question = questionsEntity.stream().filter(q -> q.getId().equals(questionAnswer.getQuestionID()))
                    .findFirst().get();

            var findCorrectAlternative = question.getAlternatives().stream()
                    .filter(alternative -> alternative.isCorrect()).findFirst().get();

            if (findCorrectAlternative.getId().equals(questionAnswer.getAlternativeID())) {
                questionAnswer.setCorrect(true);
            } else {
                questionAnswer.setCorrect(false);
            }

        });
        return dto;
    }
}
