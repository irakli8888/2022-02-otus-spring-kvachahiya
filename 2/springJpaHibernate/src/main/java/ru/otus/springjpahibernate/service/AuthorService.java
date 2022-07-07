package ru.otus.springjpahibernate.service;

import ru.otus.springjpahibernate.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    Author addAuthor(String name, String lastname);

    void deleteById(Long id);
}
