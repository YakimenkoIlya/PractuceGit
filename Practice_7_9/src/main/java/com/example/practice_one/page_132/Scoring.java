package com.example.practice_one.page_132;

import java.util.*;

public class Scoring {
    public int beginScoring(Integer[] list, boolean diagonal) {
        int scoreOne = 0;
        int scoreTwo = diagonal ? 10 : 0;
        List<Integer> numbers = Arrays.asList(list);
        Set<Integer> set = new HashSet<>();
        List<Object> duplicates = new ArrayList<>();
        numbers.forEach(n -> {
            if (!set.add(n)) {
                duplicates.add(n);
            }
        });
        Set<Integer> set2 = new HashSet<>();
        List<Object> duplicates2 = new ArrayList<>();
        duplicates.forEach(n -> {
            if (!set2.add((Integer) n)) {
                duplicates2.add(n);
            }
        });

        if (!duplicates2.isEmpty()) {
            if (set2.size() != 1) {
                if (new ArrayList<>(set).get(0) == 1 && new ArrayList<>(set).get(1) == 13) {
                    scoreOne += 100 + scoreTwo;
                } else {
                    scoreOne += 80 + scoreTwo;
                }

            } else if (duplicates2.size() == 2) {
                if (Objects.equals(duplicates2.get(0), 1)) {
                    scoreOne += 200 + scoreTwo;
                } else {
                    scoreOne += 160 + scoreTwo;
                }

            } else {
                scoreOne += 40 + scoreTwo;
            }
        } else {
            if (!duplicates.isEmpty()) {
                scoreOne += 10 * duplicates.size() + scoreTwo;
            } else {
                List<Integer> numbers2 = new ArrayList<>(set);
                boolean bool = true;
                for (int i = 0; i < 5; i++) {
                    if (numbers2.get(i) != i + 1) {
                        bool = false;
                        break;
                    }
                }
                if (bool) scoreOne += 50 + scoreTwo;
                boolean bool2 = numbers2.get(0) == 1 &&
                        numbers2.get(1) == 10 &&
                        numbers2.get(2) == 11 &&
                        numbers2.get(3) == 12 &&
                        numbers2.get(4) == 13;
                if (bool2) scoreOne += 150 + scoreTwo;
            }
        }
        return scoreOne;
    }
}