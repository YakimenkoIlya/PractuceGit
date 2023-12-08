package com.example.practice_one.page_118;

import java.util.ArrayList;

public class Dice {

    public int oneValue;
    public int twoValue;

    public static ArrayList<Dice> diceArrayList = new ArrayList<>();

    public Dice(int oneValue, int twoValue){
        this.oneValue = oneValue;
        this.twoValue = twoValue;
    }

    public static void createDices(){

        diceArrayList.add(new Dice(6, 6));

        for (int i = 0; i <= 6; i++){

            for (int j = 0; j <= 6; j++){

                boolean isDiceExistsAlready = false;

                for (Dice dice: diceArrayList) {

                    if((dice.getOneValue() == i && dice.getTwoValue() == j) ||
                            (dice.getOneValue() == j && dice.getTwoValue() == i)){

                        isDiceExistsAlready = true;
                    }
                }

                if(!isDiceExistsAlready) {
                    diceArrayList.add(new Dice(i, j));
                }
            }
        }
    }

    public int getOneValue(){
        return oneValue;
    }

    public int getTwoValue(){
        return twoValue;
    }

    public void setOneValue(int value){
        this.oneValue = value;
    }

    public void setTwoValue(int value){
        this.twoValue = value;
    }
}
