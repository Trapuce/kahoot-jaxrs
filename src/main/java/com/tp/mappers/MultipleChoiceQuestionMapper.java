package com.tp.mappers;


import com.tp.dto.MultipleChoiceQuestionDTO;
import com.tp.model.MultipleChoiceQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MultipleChoiceQuestionMapper {

    MultipleChoiceQuestionMapper INSTANCE = Mappers.getMapper(MultipleChoiceQuestionMapper.class);

    MultipleChoiceQuestionDTO toMultipleChoiceQuestionDTO(MultipleChoiceQuestion multipleChoiceQuestion);
    MultipleChoiceQuestion toMultipleChoiceQuestion(MultipleChoiceQuestionDTO multipleChoiceQuestionDTO);
}
