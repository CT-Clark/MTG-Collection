package com.example.myapplication;

import java.io.Serializable;
import java.util.List;

public class SerializableList implements Serializable {

    private List<CardModel> cards;

    public SerializableList() {

    }

    public List<CardModel> getCards() {
        return cards;
    }

    public void setCards(List<CardModel> cm) {
        this.cards = cm;
    }
}
