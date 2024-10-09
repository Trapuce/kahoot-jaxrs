package com.tp.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "game_sessions")
public class GameSession implements Serializable {

    private Long id;
    private Date startAt;
    private Date endAt;
    private String gamePin;
    private String url;
    private Date createdAt;
    private List<Player> players = new ArrayList<>();


    private User user;

    private Kahoot kahoot;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public String getGamePin() {
        return gamePin;
    }

    public void setGamePin(String gamePin) {
        this.gamePin = gamePin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "kahoot_id", nullable = false)
    public Kahoot getKahoot() {
        return kahoot;
    }

    public void setKahoot(Kahoot kahoot) {
        this.kahoot = kahoot;
    }


    @OneToMany(mappedBy = "gameSession", cascade = {CascadeType.PERSIST , CascadeType.MERGE})
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
        player.setGameSession(this);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
        player.setGameSession(null);
    }
}
