package ru.otus.springmvcview.service;

import ru.otus.springmvcview.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    Author addAuthor(String name, String lastname);

    void deleteById(Long id);
}
