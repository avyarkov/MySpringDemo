package com.github.avyarkov.MySpringDemo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Word {
    @Id String word;
    int wordCount;

    public Word() {
    }

    Word(String word, int wordCount) {
        this.word = word;
        this.wordCount = wordCount;
    }

    @Override
    public String toString() {
        return "Word{" +
            "word='" + word + '\'' +
            ", wordCount=" + wordCount +
            '}';
    }
}
