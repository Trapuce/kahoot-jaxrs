package com.tp.dto;




public class MultipleChoiceQuestionDTO extends QuestionDTO {

    private Long correctAnswerId; // ID de la réponse correcte

    public Long getCorrectAnswerId() {
        return correctAnswerId;
    }

    public void setCorrectAnswerId(Long correctAnswerId) {
        this.correctAnswerId = correctAnswerId;
    }
}
