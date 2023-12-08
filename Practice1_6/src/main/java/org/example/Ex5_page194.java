package org.example;

import java.util.Scanner;

public class Ex5_page194 {

    public static void exercise() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = scanner.nextLine();
        String cleanedText = removeExtraSpaces(text);

        System.out.println("\nТекст после удаления лишних пробелов:");
        System.out.println(cleanedText);

        scanner.close();
    }

    public static String removeExtraSpaces(String text) {
        return text.replaceAll("(\\p{P})\\s+(\\p{P})", "$1 $2").replaceAll("(\\p{P})\\s+", "$1 ");
    }
}
