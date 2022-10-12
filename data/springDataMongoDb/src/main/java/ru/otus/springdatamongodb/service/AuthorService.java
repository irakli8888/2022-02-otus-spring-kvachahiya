package ru.otus.springdatamongodb.service;


import ru.otus.springdatamongodb.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    Author addAuthor(String name, String lastname);

    void deleteById(Long id);
}
