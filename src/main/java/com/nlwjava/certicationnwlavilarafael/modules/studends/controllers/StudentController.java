package com.nlwjava.certicationnwlavilarafael.modules.studends.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlwjava.certicationnwlavilarafael.modules.studends.dto.StudentCertificationAnswerDTO;
import com.nlwjava.certicationnwlavilarafael.modules.studends.dto.VerifyHasCertificationDTO;
import com.nlwjava.certicationnwlavilarafael.modules.studends.useCases.StudentCertificationAnswersUseCase;
import com.nlwjava.certicationnwlavilarafael.modules.studends.useCases.VerifyHasCertificationUseCase;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private VerifyHasCertificationUseCase verifyHasCertificationUseCase;

    @Autowired
    private StudentCertificationAnswersUseCase studentCertificationAnswersUseCase;

    @PostMapping("/verifyHasCertification")
    public String verifyHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertification) {
        var verify = this.verifyHasCertificationUseCase.execute(verifyHasCertification);
        System.out.println(verify);
        if (verify) {
            return "nao pode fazer";
        }
        return "pode fazer";
    }

    @PostMapping("/certification/answer")
    public StudentCertificationAnswerDTO certificationAnswer(
            @RequestBody StudentCertificationAnswerDTO studentCertificationAnswerDTO) {
        return studentCertificationAnswersUseCase.execute((studentCertificationAnswerDTO));
    }
}
