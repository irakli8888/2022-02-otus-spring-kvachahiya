package ru.otus.springjpahibernate.service;

import ru.otus.springjpahibernate.model.Genre;

import java.util.List;

public interface GenreService {
    Genre add(String name);

    List<Genre> findAll();

    void deleteById(Long id);
}
