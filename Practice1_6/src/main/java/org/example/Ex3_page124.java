package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Word {
    private String content;

    public Word(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
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

class Sentence {
    private List<Word> words;

    public Sentence() {
        this.words = new ArrayList<>();
    }

    public void addWord(Word word) {
        words.add(word);
    }

    @Override
    public String toString() {
        StringBuilder sentenceString = new StringBuilder();
        for (Word word : words) {
            sentenceString.append(word.getContent()).append(" ");
        }
        return sentenceString.toString().trim();
    }
}

class Text {
    private String title;
    private List<Sentence> sentences;

    public Text(String title) {
        this.title = title;
        this.sentences = new ArrayList<>();
    }

    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    public void printTitle() {
        System.out.println("\n" + title + "\n");
    }

    public void printText() {
        for (Sentence sentence : sentences) {
            System.out.println(sentence);
        }
    }

    public static void addText() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите заголовок текста: ");
        String title = scanner.nextLine();
        Text userText = new Text(title);

        while (true) {
            Sentence sentence = new Sentence();
            System.out.println("Введите предложение или \"#выход\" для окончания ввода: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("#выход")) {
                break;
            }

            String[] words = input.split(" ");
            for (String word : words) {
                sentence.addWord(new Word(word));
            }

            userText.addSentence(sentence);
        }

        System.out.println("Вывод заголовка и текста: ");

        userText.printTitle();
        userText.printText();
    }
}

