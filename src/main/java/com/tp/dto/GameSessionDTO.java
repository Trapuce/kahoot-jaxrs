package com.tp.dto;



import java.util.Date;
import java.util.List;


public class GameSessionDTO {
    private Long id;
    private Date startAt;  // Doit être 'startAt'
    private Date endAt;
    private String gamePin;
    private String url;
    private Date createdAt;
    private List<Long> playerIds;
    private Long userId;
    private Long kahootId;

    // Constructeur par défaut
    public GameSessionDTO() {}

    // Getters et setters
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

    public List<Long> getPlayerIds() {
        return playerIds;
    }

    public void setPlayerIds(List<Long> playerIds) {
        this.playerIds = playerIds;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getKahootId() {
        return kahootId;
    }

    public void setKahootId(Long kahootId) {
        this.kahootId = kahootId;
    }
}
