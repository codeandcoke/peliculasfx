package com.svalero.peliculasfx.model;

public class Movie {

    private String name;
    private String gender;

    public Movie(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
}
