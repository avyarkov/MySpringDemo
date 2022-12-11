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
    }

    public Map<String, Integer> getWordToWordcountMap() {
        Map<String, Integer> wordToWordcountMap = new HashMap<>();
        for (var wordWithWordcount : wordRepository.findAll()) {
            wordToWordcountMap.put(wordWithWordcount.getWord(), wordWithWordcount.getWordcount());
        }
        return wordToWordcountMap;
    }

    public void addWord(String word) {
        var wordWithWordcount = wordRepository.findById(word).orElse(new WordWithWordcount(word, 0));
        wordWithWordcount.incrementWordcount();
        wordRepository.save(wordWithWordcount);
    }
}
