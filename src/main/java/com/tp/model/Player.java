package com.tp.model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "players")
public class Player implements Serializable {

    private Long id;
    private String nickname;
    private String profilePictureURL;

    public Player() {
    }

    private GameSession gameSession;

    private List<Answer> answers;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProfilePictureURL() {
        return profilePictureURL;
    }

    public void setProfilePictureURL(String profilePictureURL) {
        this.profilePictureURL = profilePictureURL;
    }

    @ManyToOne
    @JoinColumn(name = "game_session_id", nullable = false)
    public GameSession getGameSession() {
        return gameSession;
    }

    @ManyToMany
    @JoinTable(
            name = "player_answer",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id")
    )
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void setGameSession(GameSession gameSession) {
        this.gameSession = gameSession;
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
        answer.getPlayers().add(this);
    }
    public void removeAnswer(Answer answer) {
        this.answers.remove(answer);
        answer.getPlayers().remove(this);
    }
}
