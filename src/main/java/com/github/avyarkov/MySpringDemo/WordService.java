package com.github.avyarkov.MySpringDemo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {

    private List wordsList = List.of("apple", "book", "car", "door",     "zebra");

    public List<String> getWordsList() {
        return wordsList;
    }
}
