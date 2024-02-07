package com.nlwjava.certicationnwlavilarafael.modules.questions.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

import com.nlwjava.certicationnwlavilarafael.modules.baseModel.BaseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "questions")
@EqualsAndHashCode(callSuper = false)
public class QuestionEntity extends BaseEntity {

    @Column(length = 50)
    private String technology;

    private String description;
    @OneToMany
    @JoinColumn(name = "question_id")
    private List<AlternativesEntity> alternatives;
}
