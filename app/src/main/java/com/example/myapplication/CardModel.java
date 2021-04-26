package com.example.myapplication;

import java.io.Serializable;

public class CardModel implements Serializable {

    // Fields
    private int id;
    private String name;
    private String url;

    // Constructors
    public CardModel(int id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public CardModel() {
    }

    // toString
    @Override
    public String toString() {
        return "CardModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    // Getters/Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
