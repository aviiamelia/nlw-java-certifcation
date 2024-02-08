package com.nlwjava.certicationnwlavilarafael.modules.certifications.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlwjava.certicationnwlavilarafael.modules.studends.entities.CertificationStudentEntity;
import com.nlwjava.certicationnwlavilarafael.modules.studends.repositories.CertificationStudentRepository;

@Service
public class TopTenUseCase {
    @Autowired
    private CertificationStudentRepository certificationStudentRepository;

    public List<CertificationStudentEntity> execute() {
        return this.certificationStudentRepository.findTopTenByOrderByGradeDesc();
    }
}
