package ru.otus.springmvcwajax.service;

import ru.otus.springmvcwajax.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    Author addAuthor(String name, String lastname);

    void deleteById(Long id);
}
