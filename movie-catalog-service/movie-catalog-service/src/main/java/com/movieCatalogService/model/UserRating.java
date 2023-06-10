package com.movieCatalogService.model;

import java.util.List;

public class UserRating {

    private String UserId;

    private List<Rating> userRating;

    public UserRating() {
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public UserRating(String userId, List<Rating> userRating) {
        this.UserId = userId;
        this.userRating = userRating;
    }

    public List<Rating> getUserRating() {
        return userRating;
    }

    public void setUserRating(List<Rating> userRating) {
        this.userRating = userRating;
    }
}
