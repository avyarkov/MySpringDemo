package com.github.avyarkov.MySpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {
    WordRepository wordRepository;

    @Autowired
    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
        wordRepository.save(new Word("_1_one_", 1));
        wordRepository.save(new Word("_2_two_", 2));
        wordRepository.save(new Word("_3_three_", 3));
    }

    public String getWordsList() {
        return wordRepository.findAll().toString();
    }
}
