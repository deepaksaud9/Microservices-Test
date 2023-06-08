package com.movieCatalogService.model;

public class CatalogItems {
    private String movieId;
    private String name;
    private String desc;
    private int rating;


    public CatalogItems(String movieId,String name, String desc, int rating) {
        this.movieId = movieId;
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
