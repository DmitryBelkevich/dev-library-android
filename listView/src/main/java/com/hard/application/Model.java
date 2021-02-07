package com.hard.application;

public class Model {
    private long id;
    private String title;

    public Model(long id) {
        this.id = id;
        this.title = this.toString().substring((this.getClass().getName() + "@").length());
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
