package com.example.demo.model;
/*Author: Sanket Nadargi*/

public class RatingRequest {
    private int rating;

    public RatingRequest() {}

    public RatingRequest(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
