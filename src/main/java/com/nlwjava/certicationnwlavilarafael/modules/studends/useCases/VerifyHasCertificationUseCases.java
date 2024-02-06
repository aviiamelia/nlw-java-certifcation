package com.nlwjava.certicationnwlavilarafael.modules.studends.useCases;

import org.springframework.stereotype.Service;

import com.nlwjava.certicationnwlavilarafael.modules.studends.dto.VerifyHasCertificationDTO;

@Service
public class VerifyHasCertificationUseCases {
    public boolean execute(VerifyHasCertificationDTO dto) {
        if (dto.getEmail().equals("rafael@mail.com") && dto.getTechnology().equals("java")) {
            return true;
        }
        return false;
    }
}
