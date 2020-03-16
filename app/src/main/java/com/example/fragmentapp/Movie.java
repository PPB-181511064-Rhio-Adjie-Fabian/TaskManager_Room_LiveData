package com.example.fragmentapp;

public class Movie {
    private String title, rating, year;

    public Movie(String title, String rating, String year){
        this.title = title;
        this.rating = rating;
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
