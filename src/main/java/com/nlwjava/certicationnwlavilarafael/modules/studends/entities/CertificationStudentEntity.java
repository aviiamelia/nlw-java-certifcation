package com.nlwjava.certicationnwlavilarafael.modules.studends.entities;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificationStudentEntity {
    private UUID StudentId;
    private UUID id;
    private String technology;
    private int grade;
    List<AnswersCertificationsEntity> answersCertificationsEntities;
}
