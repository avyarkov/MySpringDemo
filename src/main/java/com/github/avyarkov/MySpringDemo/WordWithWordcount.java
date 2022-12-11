package com.github.avyarkov.MySpringDemo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class WordWithWordcount {
    @Id private String word;
    private int wordcount;

    public WordWithWordcount() {
    }

    WordWithWordcount(String word, int wordcount) {
        this.word = word;
        this.wordcount = wordcount;
    }

    public String getWord() {
        return word;
    }

    public int getWordcount() {
        return wordcount;
    }

    void incrementWordcount() {
        wordcount++;
    }

    @Override
    public String toString() {
        return "WordWithWordcount{" +
            "word='" + word + '\'' +
            ", wordcount=" + wordcount +
            '}';
    }
}
