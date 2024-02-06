package com.nlwjava.certicationnwlavilarafael.modules.studends.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlwjava.certicationnwlavilarafael.modules.studends.dto.VerifyHasCertificationDTO;
import com.nlwjava.certicationnwlavilarafael.modules.studends.useCases.VerifyHasCertificationUseCases;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private VerifyHasCertificationUseCases verifyHasCertificationUseCase;

    @PostMapping("/verifyHasCertification")
    public String verifyHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertification) {
        var verify = this.verifyHasCertificationUseCase.execute(verifyHasCertification);
        System.out.println(verify);
        if (verify) {
            return "deu certo";
        }
        return "deu errado";
    }
}
