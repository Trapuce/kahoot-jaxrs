package com.tp.mappers;


import com.tp.dto.*;
import com.tp.model.Answer;
import com.tp.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import com.tp.model.MultipleChoiceQuestion;
import com.tp.model.TrueFalseQuestion;

import java.util.List;

@Mapper(uses = {MultipleChoiceQuestionMapper.class , TrueFalseQuestionMapper.class})
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

   /* MultipleChoiceQuestionDTO multipleChoiceQuestionToDTO(MultipleChoiceQuestion question);
    MultipleChoiceQuestion dtoToMultipleChoiceQuestion(MultipleChoiceQuestionDTO dto);

    TrueFalseQuestionDTO trueFalseQuestionToDTO(TrueFalseQuestion question);
    TrueFalseQuestion dtoToTrueFalseQuestion(TrueFalseQuestionDTO dto);*/
    MultipleChoiceQuestionDTO map (MultipleChoiceQuestion multipleChoiceQuestion);
    TrueFalseQuestionDTO map (TrueFalseQuestion trueFalseQuestion);

    default QuestionDTO questionToQuestionDTO(Question question) {
       // QuestionDTO dto = new QuestionDTO();
        if (question instanceof MultipleChoiceQuestion) {
           return map((MultipleChoiceQuestion) question);
        } else if (question instanceof TrueFalseQuestion) {
          return map((TrueFalseQuestion) question);
        }else {
            return null;
        }


    }

    List<Answer> answersDTOToEntities(List<AnswerDTO> answerDTOs);
}
