package com.nlwjava.certicationnwlavilarafael.modules.studends.entities;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nlwjava.certicationnwlavilarafael.modules.baseModel.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
@Entity(name = "answers_certications_students")
public class AnswersCertificationsEntity extends BaseEntity {

    @Column(name = "certication_id")
    private UUID certificationId;

    @ManyToOne
    @JoinColumn(name = "certication_id", insertable = false, updatable = false)
    @JsonBackReference
    private CertificationStudentEntity certificationStudentEntity;

    @Column(name = "student_id")
    private UUID studentId;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private StudentEntity studentEntity;

    @Column(name = "question_id")
    private UUID questionID;

    @Column(name = "answer_id")
    private UUID answerID;

    @Column(name = "is_correct")
    private boolean isCorrect;
}
