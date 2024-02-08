package com.nlwjava.certicationnwlavilarafael.modules.studends.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlwjava.certicationnwlavilarafael.modules.studends.dto.VerifyHasCertificationDTO;
import com.nlwjava.certicationnwlavilarafael.modules.studends.repositories.CertificationStudentRepository;

@Service
public class VerifyHasCertificationUseCase {
    @Autowired
    private CertificationStudentRepository certificationStudentRepository;

    public boolean execute(VerifyHasCertificationDTO dto) {
        var result = this.certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(),
                dto.getTechnology());
        if (!result.isEmpty()) {
            return true;
        }
        return false;
    }
}
