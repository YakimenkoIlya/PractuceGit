package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Выберите задание, введя его номер от 1 до 6:");
        enteringExerciseNumber();
    }

    private static void enteringExerciseNumber() {

        Scanner scanner = new Scanner(System.in);
        int exerciseNumber = 1;

        try {
            exerciseNumber = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Некорректный тип данных, попробуйте снова:");
            enteringExerciseNumber();
        }

        try {
            switch (exerciseNumber) {

                case 1:
                    Ex1_page50.exercise();
                    break;
                case 2:
                    Polynomial.exercise();
                    break;
                case 3:
                    Text.addText();
                    break;
                case 4:
                    Catalog.exercise();
                    break;
                case 5:
                    Ex5_page194.exercise();
                    break;
                case 6:
                    TextEx6.addText();
                    break;
                default: {
                    System.out.println("Число неправильное, попробуйте заново");
                    enteringExerciseNumber();
                }
            }
        }catch (InputException e){
            System.out.println("\nЗаголовок или текст не могут быть пустыми\n" +
                    "Введите номер задания заново");
            enteringExerciseNumber();
        }
        scanner.close();
    }
}