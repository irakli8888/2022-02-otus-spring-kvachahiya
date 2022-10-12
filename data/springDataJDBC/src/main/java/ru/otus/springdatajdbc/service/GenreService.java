package ru.otus.springdatajdbc.service;

import ru.otus.springdatajdbc.model.Genre;

import java.util.List;

public interface GenreService {
    Genre add(String name);

    List<Genre> findAll();

    void deleteById(Long id);
}
