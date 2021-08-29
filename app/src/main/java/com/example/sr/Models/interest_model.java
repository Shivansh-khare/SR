package com.example.sr.Models;

public class interest_model {
    String Name;
    Float rating;

    public interest_model(String name, Float rating) {
        Name = name;
        this.rating = rating;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
