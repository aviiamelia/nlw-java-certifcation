package com.nlwjava.certicationnwlavilarafael.modules.studends.entities;

import java.util.List;
import java.util.UUID;

import com.nlwjava.certicationnwlavilarafael.modules.baseModel.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "certifications")
public class CertificationStudentEntity extends BaseEntity {

    @Column(length = 100)
    private String technology;

    @Column(length = 10)
    private int grade;

    @JoinColumn(name = "student_id")
    private UUID StudentID;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private StudentEntity studentEntity;

    @OneToMany
    @JoinColumn(name = "answer_certification_id", insertable = false, updatable = false)
    List<AnswersCertificationsEntity> answersCertificationsEntities;
}
