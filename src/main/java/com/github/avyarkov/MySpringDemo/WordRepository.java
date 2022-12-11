package com.github.avyarkov.MySpringDemo;

import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Word, String> {
}
