package com.github.avyarkov.MySpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class WordController {
    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping(path = "/words")
    public String getWordsList() {
        return wordService.getWordsList();
    }
}
