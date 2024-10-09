package com.tp.service;

import com.tp.dto.AnswerDTO;
import com.tp.dto.QuestionDTO;
import com.tp.mappers.AnswerMapper;
import com.tp.mappers.QuestionMapper;
import com.tp.model.*;
import com.tp.repository.impl.JpaAnswerRepository;
import com.tp.repository.impl.JpaKahootRepository;
import com.tp.repository.impl.JpaQuestionRepository;


import java.util.Date;
import java.util.List;

public class QuestionService {

    private final JpaQuestionRepository jpaQuestionRepository;
    private final JpaAnswerRepository jpaAnswerRepository;
    private final JpaKahootRepository jpaKahootRepository;
    private final QuestionMapper questionMapper;
    private final AnswerMapper answerMapper;

    public QuestionService() {
        this.jpaQuestionRepository = new JpaQuestionRepository();
        this.jpaAnswerRepository = new JpaAnswerRepository();
        this.jpaKahootRepository = new JpaKahootRepository();
        this.questionMapper = QuestionMapper.INSTANCE;
        this.answerMapper = AnswerMapper.INSTANCE;
    }

    public QuestionDTO createQuestion(QuestionDTO questionDTO, Long kahootId) {
        Kahoot kahoot = this.jpaKahootRepository.findOne(kahootId);
        if (kahoot == null) {
            throw new IllegalArgumentException("Kahoot not found");
        }

        Question question;
        if (questionDTO.getTypeQuestion().equals("multiple_choice")) {
            MultipleChoiceQuestion mcQuestion = new MultipleChoiceQuestion();
            mcQuestion.setContent(questionDTO.getContent());
            mcQuestion.setPoints(questionDTO.getPoints());
            mcQuestion.setCreatedAt(new Date());
            mcQuestion.setTimeLimit(questionDTO.getTimeLimit());
            mcQuestion.setTypeQuestion(questionDTO.getTypeQuestion());
         //   mcQuestion.setKahoot(kahoot);
            question = mcQuestion;
        } else if (questionDTO.getTypeQuestion().equals("true_or_false")) {
            TrueFalseQuestion tfQuestion = new TrueFalseQuestion();
            tfQuestion.setContent(questionDTO.getContent());
            tfQuestion.setPoints(questionDTO.getPoints());
            tfQuestion.setCreatedAt(new Date());
            tfQuestion.setTimeLimit(questionDTO.getTimeLimit());
           // tfQuestion.setKahoot(kahoot);
            question = tfQuestion;
        } else {
            throw new IllegalArgumentException("Invalid question type");
        }
        kahoot.addQuestion(question);
        this.jpaQuestionRepository.save(question);

        //List<Answer> answers = questionMapper.answersDTOToEntities(questionDTO.getAnswers());
        List<AnswerDTO> answerDTOS = questionDTO.getAnswers();
        for (AnswerDTO answerDTO : answerDTOS) {
            Answer answer  = this.answerMapper.answerDTOToAnswer(answerDTO);
            answer.setCreatedAt(new Date());
            answer.setIsCorrect(answerDTO.getCorrect() != null ? answerDTO.getCorrect() : false);
            answer.setQuestion(question);  // Ensure that each answer is linked to the saved question
            this.jpaAnswerRepository.save(answer);
        }

        return questionMapper.questionToQuestionDTO(question);
    }

}
