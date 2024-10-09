package com.tp.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "kahoots")
public class Kahoot implements Serializable {

    private Long id;
    private String title;
    private String description;
    private Boolean isPublic;
    private String coverImageURL;
    private Date createdAt;


    private User user;

   private List<GameSession> gameSessions = new ArrayList<>();

    private List<Question> questions = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public String getCoverImageURL() {
        return coverImageURL;
    }

    public void setCoverImageURL(String coverImageURL) {
        this.coverImageURL = coverImageURL;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id" , nullable = false )
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "kahoot", cascade ={ CascadeType.PERSIST, CascadeType.MERGE})
    public List<GameSession> getGameSessions() {
        return gameSessions;
    }

    public void setGameSessions(List<GameSession> gameSessions) {
        this.gameSessions = gameSessions;
    }

    @OneToMany(mappedBy = "kahoot", cascade ={ CascadeType.ALL})
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addGameSession(GameSession gameSession) {
        this.gameSessions.add(gameSession);
        gameSession.setKahoot(this);
    }
    public void removeGameSession(GameSession gameSession) {
        this.gameSessions.remove(gameSession);
        gameSession.setKahoot(null);
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
        question.setKahoot(this);
    }
    public void removeQuestion(Question question) {
        this.questions.remove(question);
        question.setKahoot(null);
    }
}
