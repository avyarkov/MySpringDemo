package com.github.avyarkov.MySpringDemo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class WordWithWordcount {
    @Id String word;
    int wordcount;

    public WordWithWordcount() {
    }

    WordWithWordcount(String word, int wordcount) {
        this.word = word;
        this.wordcount = wordcount;
    }

    @Override
    public String toString() {
        return "WordWithWordcount{" +
            "word='" + word + '\'' +
            ", wordcount=" + wordcount +
            '}';
    }
}
