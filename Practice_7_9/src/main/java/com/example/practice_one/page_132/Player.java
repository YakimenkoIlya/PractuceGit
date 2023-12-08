package com.example.practice_one.page_132;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.Map;
import java.util.Objects;

public class Player {
    protected GridPane pole;
    public Map elements;
    Card card;
    Computer computer;
    public Player(GridPane gridPane, Map elements, Card card, Computer computer){
        this.pole = gridPane;
        this.elements = elements;
        this.card = card;
        this.computer = computer;
    }
    public void putCard(){
        pole.getChildren().forEach(item -> item.setOnMouseClicked(event -> {
            if (Objects.equals(getPlayerLabel(item.getId()).getText(), "")) {
                getPlayerLabel(item.getId()).setText(String.valueOf(card.getCurrentCard()));
                computer.putCard(Player.this);
            }
        }));
    }

    private Label getPlayerLabel(String id){
        return (Label) elements.get(id);
    }
}