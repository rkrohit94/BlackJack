package com.allstate.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Card {

    private String card;
    private String suite;

    public Card() {
    }

    public Card(String card, String suite) {
        this.card = card;
        this.suite = suite;
    }

    @JsonProperty("card")
    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @JsonProperty("suite")
    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }
}
