package com.tp.model;



import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("multiple_choice")
public class MultipleChoiceQuestion extends Question {

    @ManyToOne
    @JoinColumn(name = "correct_answer_id")
    private Answer correctAnswer;

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }


}


