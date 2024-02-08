package com.nlwjava.certicationnwlavilarafael.modules.studends.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nlwjava.certicationnwlavilarafael.modules.baseModel.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "students")
@Builder
public class StudentEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "studentEntity")
    @JsonBackReference
    private List<CertificationStudentEntity> certificationStudentEntity;

}
