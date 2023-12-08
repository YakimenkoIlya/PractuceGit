package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class WordEx6 {
    private String content;

    public WordEx6(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordEx6 word = (WordEx6) o;
        return content.equals(word.content);
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }

    @Override
    public String toString() {
        return content;
    }
}

class SentenceEx6 {
    private List<WordEx6> words;

    public SentenceEx6() {
        this.words = new ArrayList<>();
    }

    public void addWord(WordEx6 word) {
        words.add(word);
    }

    @Override
    public String toString() {
        StringBuilder sentenceString = new StringBuilder();
        for (WordEx6 word : words) {
            sentenceString.append(word.getContent()).append(" ");
        }
        return sentenceString.toString().trim();
    }
}

class TextEx6 {
    private String title;
    private List<SentenceEx6> sentences;

    public TextEx6(String title) {
        this.title = title;
        this.sentences = new ArrayList<>();
    }

    public void addSentence(SentenceEx6 sentence) {
        sentences.add(sentence);
    }

    public void printTitle() {
        System.out.println("\n" + title + "\n");
    }

    public void printText() {
        for (SentenceEx6 sentence : sentences) {
            System.out.println(sentence);
        }
    }

    public static void addText() throws InputException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите заголовок текста: ");
        String title = scanner.nextLine();
        if (title.isEmpty()) {
            throw new InputException("Заголовок не может быть пустым");
        }
        TextEx6 userText = new TextEx6(title);

        while (true) {
            System.out.println("Введите предложение или \"#выход\" для окончания ввода: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("#выход")) {
                break;
            }

            if (input.isEmpty()) {
                throw new InputException("Текст не может быть пустым");
            }

            SentenceEx6 sentence = new SentenceEx6();
            String[] words = input.split(" ");
            for (String word : words) {
                sentence.addWord(new WordEx6(word));
            }

            userText.addSentence(sentence);
        }

        System.out.println("Вывод заголовка и текста: ");

        userText.printTitle();
        userText.printText();
        scanner.close();
    }
}

class InputException extends Exception{

    public InputException(String message){

        super(message);
    }
}