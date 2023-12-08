package com.example.practice_one.page_132;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Computer {
    protected GridPane pole;
    public Map elem;
    Card card;
    public Computer(GridPane pole, Map elem, Card card){
        this.pole = pole;
        this.elem = elem;
        this.card = card;
    }
    public void putCard(Player player){
        while (true) {
            int i1 = new Random().nextInt(0, 5),
                    i2 = new Random().nextInt(0, 5);
            if (Objects.equals(getCompLabel(getCoordinates(i1, i2)).getText(), "")) {
                getCompLabel(getCoordinates(i1,i2)).setText(String.valueOf(card.getCurrentCard()));
                card.cardNew();
                card.writeCurrentCard();
                break;
            }
        }
        boolean bool = false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String b = getCompLabel(getCoordinates(i, j)).getText();
                if (Objects.equals(b, "")) {
                    bool = false;
                    break;
                }else {
                    bool = true;
                }
            }if (!bool) break;
        }
        if (bool){
            new Check(elem, pole, player.elements, player.pole, card).getResults();
        }
    }
    private Label getCompLabel(String id){
        return (Label) elem.get(id);
    }
    public String getCoordinates(int i, int j){
        return pole.getChildren().get(i*5+j).getId();
    }
}
