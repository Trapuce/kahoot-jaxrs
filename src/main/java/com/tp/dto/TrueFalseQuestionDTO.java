package com.tp.dto;

public class TrueFalseQuestionDTO extends QuestionDTO {

    private boolean correctAnswer; // Indique si la réponse correcte est "Vrai" ou "Faux"

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
