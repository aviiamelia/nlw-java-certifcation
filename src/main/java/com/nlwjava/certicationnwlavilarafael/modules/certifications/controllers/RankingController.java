package com.nlwjava.certicationnwlavilarafael.modules.certifications.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.nlwjava.certicationnwlavilarafael.modules.certifications.useCases.TopTenUseCase;
import com.nlwjava.certicationnwlavilarafael.modules.studends.entities.CertificationStudentEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    @Autowired
    private TopTenUseCase topTen;

    @GetMapping("/topten")
    public List<CertificationStudentEntity> topTen() {
        return this.topTen.execute();
    }
}
