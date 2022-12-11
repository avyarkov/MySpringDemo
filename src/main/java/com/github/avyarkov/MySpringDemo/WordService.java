package com.github.avyarkov.MySpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WordService {
    private final WordRepository wordRepository;

    @Autowired
    WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
        wordRepository.save(new WordWithWordcount("_1_one_", 1));
        wordRepository.save(new WordWithWordcount("_2_two_", 2));
        wordRepository.save(new WordWithWordcount("_3_three_", 3));
    }

    Map<String, Integer> getWordToWordcountMap() {
        Map<String, Integer> wordToWordcount = new HashMap<>();
        for (var wordWithWordcount : wordRepository.findAll()) {
            wordToWordcount.put(wordWithWordcount.word, wordWithWordcount.wordcount);
        }
        return wordToWordcount;
    }
}
