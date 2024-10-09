package com.tp.dto;


import java.util.Date;
import java.util.List;

public class KahootDTO {
    private Long id;
    private String title;
    private String description;
    private Boolean isPublic;
    private String coverImageURL;
    private Date createdAt;
    private Long userId;
    private List<Long> gameSessionIds;
    private List<Long> questionIds;

    // Constructeurs, getters et setters

    public KahootDTO() {}

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

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getGameSessionIds() {
        return gameSessionIds;
    }

    public void setGameSessionIds(List<Long> gameSessionIds) {
        this.gameSessionIds = gameSessionIds;
    }

    public List<Long> getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(List<Long> questionIds) {
        this.questionIds = questionIds;
    }

}