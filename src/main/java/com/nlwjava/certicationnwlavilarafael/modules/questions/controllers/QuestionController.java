package com.nlwjava.certicationnwlavilarafael.modules.questions.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.nlwjava.certicationnwlavilarafael.modules.questions.dto.AlternativeResultDTO;
import com.nlwjava.certicationnwlavilarafael.modules.questions.dto.QuestionResultDTO;
import com.nlwjava.certicationnwlavilarafael.modules.questions.entities.AlternativesEntity;
import com.nlwjava.certicationnwlavilarafael.modules.questions.entities.QuestionEntity;
import com.nlwjava.certicationnwlavilarafael.modules.questions.repositories.QuestionRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/technology/{technology}")
    public List<QuestionResultDTO> findByTechnology(@PathVariable String technology) {
        var result = this.questionRepository.findByTechnology(technology);

        var toMap = result.stream().map(question -> mapQuestionToDTO(question)).collect(Collectors.toList());
        return toMap;
    }

    static QuestionResultDTO mapQuestionToDTO(QuestionEntity question) {
        var questionResultDTO = QuestionResultDTO.builder().id(question.getId()).technology(question.getTechnology())
                .description(question.getDescription())
                .build();

        List<AlternativeResultDTO> alternativeResulltDTOs = question.getAlternatives().stream()
                .map(alternative -> mapAlternativeDTO(alternative)).collect(Collectors.toList());
        questionResultDTO.setAlternatives(alternativeResulltDTOs);
        return questionResultDTO;
    }

    static AlternativeResultDTO mapAlternativeDTO(AlternativesEntity alternativesResultDIO) {
        return AlternativeResultDTO.builder().id(alternativesResultDIO.getId())
                .description(alternativesResultDIO.getDescription()).build();
    }
}
