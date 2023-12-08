package com.example.practice_one.page_132;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.Map;

public class Check {
    private Map elemC, elemP;
    private int markC = 0, markP = 0;
    private GridPane poleC, poleP;
    private Card card;

    public static String compResult = "";
    public static String playerResult = "";

    public Check(Map elemC, GridPane poleC, Map elemP, GridPane poleP, Card card) {
        this.elemC = elemC;
        this.elemP = elemP;
        this.poleC = poleC;
        this.poleP = poleP;
        this.card = card;
    }

    private int compCheck() {
        for (int i = 0; i < 5; i++) {
            Integer[] list = new Integer[5];
            for (int j = 0; j < 5; j++) {
                int b = Integer.parseInt(compLabel(elemC, getID(poleC, i, j)).getText());
                list[j] = b;
            }
            markC += new Scoring().beginScoring(list, false);
        }

        for (int i = 0; i < 5; i++) {
            Integer[] list = new Integer[5];
            for (int j = 0; j < 5; j++) {
                int b = Integer.parseInt(compLabel(elemC, getID(poleC, j, i)).getText());
                list[j] = b;
            }
            markC += new Scoring().beginScoring(list, false);
        }

        Integer[] list = new Integer[5];
        for (int i = 0; i < 5; i++) {
            int b = Integer.parseInt(compLabel(elemC, getID(poleC, i, i)).getText());
            list[i] = b;
        }
        markC += new Scoring().beginScoring(list, true);

        Integer[] list2 = new Integer[5];
        for (int i = 0; i < 5; i++) {
            int b = Integer.parseInt(compLabel(elemC, getID(poleC, i, 4 - i)).getText());
            list2[i] = b;
        }
        markC += new Scoring().beginScoring(list2, true);
        return markC;
    }

    private int playerCheck() {

        for (int i = 0; i < 5; i++) {
            Integer[] list = new Integer[5];
            for (int j = 0; j < 5; j++) {
                int b = Integer.parseInt(compLabel(elemP, getID(poleP, i, j)).getText());
                list[j] = b;
            }
            markP += new Scoring().beginScoring(list, false);
        }

        for (int i = 0; i < 5; i++) {
            Integer[] list = new Integer[5];
            for (int j = 0; j < 5; j++) {
                int b = Integer.parseInt(compLabel(elemP, getID(poleP, j, i)).getText());
                list[j] = b;
            }
            markP += new Scoring().beginScoring(list, false);
        }

        Integer[] list = new Integer[5];
        for (int i = 0; i < 5; i++) {
            int b = Integer.parseInt(compLabel(elemP, getID(poleP, i, i)).getText());
            list[i] = b;
        }
        markP += new Scoring().beginScoring(list, true);

        Integer[] list2 = new Integer[5];
        for (int i = 0; i < 5; i++) {
            int b = Integer.parseInt(compLabel(elemP, getID(poleP, i, 4 - i)).getText());
            list2[i] = b;
        }
        markP += new Scoring().beginScoring(list2, true);
        return markP;
    }
    public void getResults() {

        compResult = String.valueOf(compCheck());
        playerResult = String.valueOf(playerCheck());
    }
    public String getID(GridPane pole, int i, int j) {
        return pole.getChildren().get(i * 5 + j).getId();
    }

    private Label compLabel(Map elem, String id) {
        return (Label) elem.get(id);
    }
}
