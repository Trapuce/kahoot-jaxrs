package com.tp.model;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {


    private Long id;
    private String username;
    private String email;
    private Date createdAt;


    private List<GameSession> gameSessions = new ArrayList<>();
    private List<Kahoot> kahoots = new ArrayList<>();

    public User() {

    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @OneToMany(mappedBy = "user", cascade ={CascadeType.PERSIST , CascadeType.MERGE})
    public List<GameSession> getGameSessions() {
        return gameSessions;
    }

    public void setGameSessions(List<GameSession> gameSessions) {
        this.gameSessions = gameSessions;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<Kahoot> getKahoots() {
        return kahoots;
    }

    public void setKahoots(List<Kahoot> kahoots) {
        this.kahoots = kahoots;
    }

    public void addKahoot(Kahoot kahoot) {
        this.kahoots.add(kahoot);
        kahoot.setUser(this);
    }

    public void removeKahoot(Kahoot kahoot) {
        this.kahoots.remove(kahoot);
        kahoot.setUser(null);
    }

    public void addGameSession(GameSession gameSession) {
        this.gameSessions.add(gameSession);
        gameSession.setUser(this);
    }

    public void removeGameSession(GameSession gameSession) {
        this.gameSessions.remove(gameSession);
        gameSession.setUser(null);
    }
}
