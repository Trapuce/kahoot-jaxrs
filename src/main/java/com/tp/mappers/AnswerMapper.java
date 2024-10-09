package com.tp.mappers;


import com.tp.dto.AnswerDTO;
import com.tp.model.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    AnswerDTO answerToAnswerDTO(Answer answer);
    Answer answerDTOToAnswer(AnswerDTO answerDTO);
    List<Answer> answersDTOToEntities(List<AnswerDTO> answerDTOs);

}

