package com.tp.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerDTO {

    private Long id;
    private String content;

    @JsonProperty("isCorrect")
    private Boolean isCorrect;

    public QuestionDTO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDTO question) {
        this.question = question;
    }

    private QuestionDTO question;

    public AnswerDTO() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("isCorrect")
    public Boolean getCorrect() {  // Vous pouvez conserver getCorrect
        return isCorrect;
    }

    @JsonProperty("isCorrect")
    public void setCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
