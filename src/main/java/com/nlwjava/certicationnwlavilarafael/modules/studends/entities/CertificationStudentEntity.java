package com.nlwjava.certicationnwlavilarafael.modules.studends.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nlwjava.certicationnwlavilarafael.modules.baseModel.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "certifications")
@Builder
public class CertificationStudentEntity extends BaseEntity {

    @Column(length = 100)
    private String technology;

    @Column(length = 10)
    private int grade;

    @Column(name = "student_id")
    private UUID StudentID;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private StudentEntity studentEntity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_certification_id", insertable = false, updatable = false)
    @JsonManagedReference
    List<AnswersCertificationsEntity> answersCertificationsEntities;
}
