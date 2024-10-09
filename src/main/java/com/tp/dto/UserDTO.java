package com.tp.dto;



import java.util.Date;
import java.util.List;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private Date createdAt;
    private List<Long> gameSessionIds;
    private List<Long> kahootIds;


    public UserDTO() {}

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

    public List<Long> getGameSessionIds() {
        return gameSessionIds;
    }

    public void setGameSessionIds(List<Long> gameSessionIds) {
        this.gameSessionIds = gameSessionIds;
    }

    public List<Long> getKahootIds() {
        return kahootIds;
    }

    public void setKahootIds(List<Long> kahootIds) {
        this.kahootIds = kahootIds;
    }
}

