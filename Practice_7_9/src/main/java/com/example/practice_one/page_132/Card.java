package com.example.practice_one.page_132;

import javafx.scene.control.Label;

import java.util.Random;

public class Card {
    private  int i = new Random().nextInt(0, 3);
    private  int j = new Random().nextInt(0, 12);
    private int[][] cards = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}};
    private int currentCard = cards[i][j];
    public Label label;
    public Card(Label label) {
        this.label = label;
    }

    public void cardNew() {
        cards[i][j] = -1;

        do {
            i = new Random().nextInt(0, 4);
            j = new Random().nextInt(0, 13);
            currentCard = cards[i][j];

        }while (currentCard == -1);
    }

    public void writeCurrentCard() {
        label.setText("Текущая карта: " + currentCard);
    }

    public int getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(int currentCard) {
        this.currentCard = currentCard;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
}
