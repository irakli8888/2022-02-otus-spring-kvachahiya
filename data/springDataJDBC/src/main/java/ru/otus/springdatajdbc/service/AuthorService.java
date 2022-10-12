package ru.otus.springdatajdbc.service;

import ru.otus.springdatajdbc.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    Author addAuthor(String name, String lastname);

    void deleteById(Long id);
}
