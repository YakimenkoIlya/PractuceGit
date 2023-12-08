package com.example.practice_one.page_118;

import com.example.practice_one.HelloApplication;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.*;

public class Page118 {
    @FXML
    private Button B;
    @FXML
    private Button B1;
    @FXML
    private Button B2;
    @FXML
    private Button B3;
    @FXML
    private Button B4;
    @FXML
    private Button B5;
    @FXML
    private Button B6;
    @FXML
    private Button B7;
    @FXML
    private Button B8;
    @FXML
    private Button B9;
    @FXML
    private Button B10;
    @FXML
    private Button B11;
    @FXML
    private Button B12;
    @FXML
    private Button B13;
    @FXML
    private Button B14;
    @FXML
    private Button B15;
    @FXML
    private Button B16;
    @FXML
    private Button B17;
    @FXML
    private Button B18;
    @FXML
    private Button B19;
    @FXML
    private Label compDicesCount;
    @FXML
    private Label currentDice;
    private static ArrayList<Dice> playerDices = new ArrayList<>();
    private static ArrayList<Dice> compDices = new ArrayList<>();
    private static Dice mainDice = new Dice(0, 0);
    private static boolean isPlayerTurn;
    private static String status;
    private static boolean isGameOver = false;
    private static final int MAX_HAND_SIZE = 20;

    public static void show() {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("page118.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Домино");
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    @FXML
    public static void startGame(){

        Dice.createDices();
        Collections.shuffle(Dice.diceArrayList);
        startingDistribution();
        firstTurnDetermination();
        show();
    }

    private static void autoDraw(){

            if(!canTakeTurn()){

                if(isPlayerTurn){

                    while (playerDices.size() < MAX_HAND_SIZE){

                        if(!canTakeTurn()){

                            if(!Dice.diceArrayList.isEmpty()){

                                takeDice();
                            }
                            else
                                if(!canTakeTurn()){

                                    isGameOver = true;
                                    status = "Вы проиграли!";
                                    return;
                                }
                        }
                        else return;
                    }

                    if(!canTakeTurn()) {
                        isGameOver = true;
                        status = "Вы проиграли!";
                    }
                }
                else {

                    while (compDices.size() < MAX_HAND_SIZE){

                        if(!canTakeTurn()){

                            if(!Dice.diceArrayList.isEmpty()){

                                takeDice();
                            }
                            else
                            if(!canTakeTurn()){

                                isGameOver = true;
                                status = "Вы победили!";
                                return;
                            }
                        }
                        else return;
                    }

                    if(!canTakeTurn()) {
                        isGameOver = true;
                        status = "Вы победили!";
                    }
                }
            }
        }

    public static void takeDice(){

        Iterator<Dice> diceIterator = Dice.diceArrayList.iterator();

            if(isPlayerTurn){

                playerDices.add(Dice.diceArrayList.get(0));
            }
            else {

                compDices.add(Dice.diceArrayList.get(0));
            }

            diceIterator.next();
            diceIterator.remove();
    }

    private static boolean canTakeTurn(){

        if(isPlayerTurn){

            for (Dice dice: playerDices) {

                if(mainDice.getOneValue() == dice.getOneValue() ||
                        mainDice.getOneValue() == dice.getTwoValue() ||
                        mainDice.getTwoValue() == dice.getOneValue() ||
                        mainDice.getTwoValue() == dice.getTwoValue()) {

                    return true;
                }
            }
            return false;
        }
        else {
            for (Dice dice: compDices) {

                if(mainDice.getOneValue() == dice.getOneValue() ||
                        mainDice.getOneValue() == dice.getTwoValue() ||
                        mainDice.getTwoValue() == dice.getOneValue() ||
                        mainDice.getTwoValue() == dice.getTwoValue()) {
                    return true;
                }
            }
            return false;
        }
    }

    private static boolean coincidenceCheck(int diceIndex) {

        if (isGameOver){

            return false;
        }

        Dice choosenDice;

        if (isPlayerTurn) {

            choosenDice = playerDices.get(diceIndex);
        } else choosenDice = compDices.get(diceIndex);

        if (choosenDice.getOneValue() == mainDice.getOneValue()) {

            mainDice.setOneValue(choosenDice.getTwoValue());
        } else {
            if (choosenDice.getOneValue() == mainDice.getTwoValue()) {

                mainDice.setTwoValue(choosenDice.getTwoValue());
            } else {
                if (choosenDice.getTwoValue() == mainDice.getOneValue()) {

                    mainDice.setOneValue(choosenDice.getOneValue());
                } else {
                    if (choosenDice.getTwoValue() == mainDice.getTwoValue()) {

                        mainDice.setTwoValue(choosenDice.getOneValue());
                    } else
                        return false;
                }
            }
        }
        layOutDice(diceIndex);
        return true;
    }

    private static void layOutDice(int diceIndex) {
        List<Dice> dices;

        if (isPlayerTurn) {

            dices = playerDices;

        } else {

            dices = compDices;
        }

        if (diceIndex >= 0 && diceIndex < dices.size()) {
            dices.remove(diceIndex);
        }
        handOverCheck();
    }

    private static void startingDistribution(){

        Iterator<Dice> diceIterator = Dice.diceArrayList.iterator();

        for (int i = 0; i < 7; i++){

            playerDices.add(Dice.diceArrayList.get(0));
            diceIterator.next();
            diceIterator.remove();

            compDices.add(Dice.diceArrayList.get(0));
            diceIterator.next();
            diceIterator.remove();
        }
    }

    private static void firstTurnDetermination(){

        boolean isOneDoubleExists = false;

        ArrayList<Dice> generalStartSet = new ArrayList<>(playerDices);

        generalStartSet.addAll(compDices);

        for (Dice dice: generalStartSet) {

            if(dice.getOneValue() == 1 && dice.getTwoValue() == 1){

                mainDice.setOneValue(dice.getOneValue());
                mainDice.setTwoValue(dice.getTwoValue());

                isOneDoubleExists = true;
            }
        }

        if(!isOneDoubleExists){

            int onePossibleValue = 0;
            int twoPossibleValue = 1;
            boolean isSuitableDiceFound = false;

            while (!isSuitableDiceFound) {

                for (Dice dice : generalStartSet) {

                    if (dice.getOneValue() == onePossibleValue &&
                            dice.getTwoValue() == twoPossibleValue ||
                            dice.getOneValue() == twoPossibleValue &&
                                    dice.getTwoValue() == onePossibleValue) {

                        mainDice.setOneValue(dice.getOneValue());
                        mainDice.setTwoValue(dice.getTwoValue());
                        isSuitableDiceFound = true;
                    }
                }

                if(onePossibleValue != twoPossibleValue){

                    ++onePossibleValue;
                }
                else {

                    ++twoPossibleValue;
                }
            }
        }

        int deleteIndex = 0;

        for (Dice dice: playerDices) {

            if(mainDice.getOneValue() == dice.getOneValue() &&
                    mainDice.getTwoValue() == dice.getTwoValue() ||
                    mainDice.getOneValue() == dice.getTwoValue() &&
                    mainDice.getTwoValue() == dice.getOneValue()){

                isPlayerTurn = true;
                layOutDice(deleteIndex);
                compTurn();
                return;
            }
            ++deleteIndex;
        }

        deleteIndex = 0;

        for (Dice dice: compDices) {

            if(mainDice.getOneValue() == dice.getOneValue() &&
                    mainDice.getTwoValue() == dice.getTwoValue() ||
                    mainDice.getOneValue() == dice.getTwoValue() &&
                            mainDice.getTwoValue() == dice.getOneValue()){

                isPlayerTurn = false;
                layOutDice(deleteIndex);
                playerTurn();
                return;
            }
            ++deleteIndex;
        }
    }

    @FXML
    private void initialize(){

        Button[] buttonArray = {B, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10,
                B11, B12, B13, B14, B15, B16, B17, B18, B19};

        Timeline timeline = new Timeline();

        javafx.util.Duration duration = new Duration(100);

        KeyFrame keyFrame = new KeyFrame(duration, event -> {

            compDicesCount.setText("Костяшек у оппонента: " + compDices.size());

            if(!isGameOver){

                currentDice.setText("[" + mainDice.getOneValue() + "][" +
                        mainDice.getTwoValue() + "]");

                for (int i = 0; i < MAX_HAND_SIZE; i++) {

                    if(i <= playerDices.size() - 1){

                        buttonArray[i].setOpacity(1);
                        buttonArray[i].setDisable(false);
                        buttonArray[i].setText("[" + playerDices.get(i).getOneValue() +
                                "][" + playerDices.get(i).getTwoValue() + "]");
                    }
                    else {

                        buttonArray[i].setOpacity(0);
                        buttonArray[i].setDisable(true);
                    }
                }
                }
            else {

                currentDice.setText(status);

                for (Button button: buttonArray) {

                    button.setDisable(true);
                }
            }
            }
        );

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

    private static void handOverCheck(){

        if(playerDices.isEmpty()){

            status = "Вы победили";
            isGameOver = true;
        }

        if(compDices.isEmpty()){

            status = "Вы проиграли";
            isGameOver = true;
        }
    }

    private static void playerTurn(){

        isPlayerTurn = true;

        autoDraw();

    }
    private static void compTurn(){

        isPlayerTurn = false;

        autoDraw();

        if(!isGameOver){

            for (Dice dice: compDices) {

                if (coincidenceCheck(compDices.indexOf(dice))) break;
            }

            if(!compDices.isEmpty()){

                playerTurn();
            }
        }

    }

    @FXML
    protected void buttonClick(){

        if(coincidenceCheck(0)) compTurn();
    }

    @FXML
    protected void buttonClick1(){

        if(coincidenceCheck(1)) compTurn();
    }

    @FXML
    protected void buttonClick2(){

        if(coincidenceCheck(2)) compTurn();
    }

    @FXML
    protected void buttonClick3(){

        if(coincidenceCheck(3)) compTurn();
    }

    @FXML
    protected void buttonClick4(){

        if(coincidenceCheck(4)) compTurn();
    }

    @FXML
    protected void buttonClick5(){

        if(coincidenceCheck(5)) compTurn();
    }

    @FXML
    protected void buttonClick6(){

        if(coincidenceCheck(6)) compTurn();
    }

    @FXML
    protected void buttonClick7(){

        if(coincidenceCheck(7)) compTurn();
    }

    @FXML
    protected void buttonClick8(){

        if(coincidenceCheck(8)) compTurn();
    }

    @FXML
    protected void buttonClick9(){

        if(coincidenceCheck(9)) compTurn();
    }
    @FXML
    protected void buttonClick10(){

        if(coincidenceCheck(10)) compTurn();
    }

    @FXML
    protected void buttonClick11(){

        if(coincidenceCheck(11)) compTurn();
    }

    @FXML
    protected void buttonClick12(){

        if(coincidenceCheck(12)) compTurn();
    }

    @FXML
    protected void buttonClick13(){

        if(coincidenceCheck(13)) compTurn();
    }

    @FXML
    protected void buttonClick14(){

        if(coincidenceCheck(14)) compTurn();
    }

    @FXML
    protected void buttonClick15(){

        if(coincidenceCheck(15)) compTurn();
    }

    @FXML
    protected void buttonClick16(){

        if(coincidenceCheck(16)) compTurn();
    }

    @FXML
    protected void buttonClick17(){

        if(coincidenceCheck(17)) compTurn();
    }

    @FXML
    protected void buttonClick18(){

        if(coincidenceCheck(18)) compTurn();
    }

    @FXML
    protected void buttonClick19(){

        if(coincidenceCheck(19)) compTurn();
    }
}