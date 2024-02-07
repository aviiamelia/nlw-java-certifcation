package com.nlwjava.certicationnwlavilarafael.modules.questions.dto;

import java.util.UUID;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionResultDTO {
    private UUID id;
    private String technology;
    private String description;
    private List<AlternativeResultDTO> alternatives;
}
