package com.nlwjava.certicationnwlavilarafael.modules.questions.entities;

import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.nlwjava.certicationnwlavilarafael.modules.baseModel.BaseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "alternatives")
public class AlternativesEntity extends BaseEntity {
    private String description;
    private boolean isCorrect;
}
