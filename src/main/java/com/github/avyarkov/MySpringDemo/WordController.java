package com.github.avyarkov.MySpringDemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @GetMapping(path = "/")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @GetMapping(path = "/words", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getWordsWithWordCounts() throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(wordService.getWordToWordcountMap());
    }

    @GetMapping(path = "/addWord")
    public ModelAndView addWordGetWithParam(@RequestParam String word) {
        wordService.addWord(word);
        return new ModelAndView("home");
    }

    @GetMapping(path = "/add")
    public ModelAndView addWordGet() {
        return new ModelAndView("addWordForm");
    }

    @PostMapping(path = "/add")
    public ModelAndView addWordPost(@RequestParam(name = "word") String word) {
        wordService.addWord(word);
        return new ModelAndView("home");
    }


    @GetMapping(path = "/dto", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dto<String> dto(
        @RequestParam(defaultValue = "") String string,
        @RequestParam(defaultValue = "") List<String> warnings)
    {
        return Dto.success("data", string, warnings);
    }

    @PostMapping(path = "/request", produces = MediaType.APPLICATION_JSON_VALUE)
    public String request(@RequestBody Request request) throws JsonProcessingException {
        return objectMapper.writeValueAsString(request);
    }
}
