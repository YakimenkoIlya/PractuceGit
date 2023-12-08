package org.example;

import java.util.Scanner;

public class Ex1_page50 {

public static void exercise(){

    Scanner scanner = new Scanner(System.in);

    System.out.print("Введите значение n: ");
    double n = scanner.nextDouble();

    System.out.print("Введите значение m: ");
    double m = scanner.nextDouble();

    System.out.print("Введите значение k: ");
    double k = scanner.nextDouble();

    if (k > n && k <= m) {
        System.out.println("Значение k принадлежит интервалу (n, m]");
    } else {
        System.out.println("Значение k не принадлежит интервалу (n, m]");
    }

    if (k >= n && k < m) {
        System.out.println("Значение k принадлежит интервалу [n, m)");
    } else {
        System.out.println("Значение k не принадлежит интервалу [n, m)");
    }

    if (k > n && k < m) {
        System.out.println("Значение k принадлежит интервалу (n, m)");
    } else {
        System.out.println("Значение k не принадлежит интервалу (n, m)");
    }

    if (k >= n && k <= m) {
        System.out.println("Значение k принадлежит интервалу [n, m]");
    } else {
        System.out.println("Значение k не принадлежит интервалу [n, m]");
    }

    scanner.close();
    }
}