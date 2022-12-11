package com.github.avyarkov.MySpringDemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class WordController {
    private final WordService wordService;
    private final ObjectMapper objectMapper;

    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
        this.objectMapper = new ObjectMapper();
    }

    @GetMapping(path = "/words", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getWordsWithWordCounts() throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(wordService.getWordToWordcountMap());
    }
}
