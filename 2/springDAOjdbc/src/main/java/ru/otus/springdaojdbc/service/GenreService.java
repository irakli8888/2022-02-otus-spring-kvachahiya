package ru.otus.springdaojdbc.service;

import ru.otus.springdaojdbc.model.Genre;

public interface GenreService {
    Genre add(String name);

    void findAll();

    void deleteById(Long id);
}
