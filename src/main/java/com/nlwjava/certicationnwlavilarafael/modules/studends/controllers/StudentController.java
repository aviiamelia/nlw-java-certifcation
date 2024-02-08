package com.nlwjava.certicationnwlavilarafael.modules.studends.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> certificationAnswer(
            @RequestBody StudentCertificationAnswerDTO studentCertificationAnswerDTO) throws Exception {
        try {
            var result = studentCertificationAnswersUseCase.execute((studentCertificationAnswerDTO));
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
