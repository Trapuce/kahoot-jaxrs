package com.tp.mappers;


import com.tp.dto.TrueFalseQuestionDTO;
import com.tp.model.TrueFalseQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TrueFalseQuestionMapper {

    TrueFalseQuestionMapper INSTANCE = Mappers.getMapper(TrueFalseQuestionMapper.class);

    TrueFalseQuestionDTO toDto(TrueFalseQuestion question);
    TrueFalseQuestion toEntity(TrueFalseQuestionDTO questionDTO);
}
