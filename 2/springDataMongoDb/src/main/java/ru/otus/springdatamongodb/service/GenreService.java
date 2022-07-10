package ru.otus.springdatamongodb.service;


import ru.otus.springdatamongodb.model.Genre;

import java.util.List;


public interface GenreService {
    Genre add(String name);

    List<Genre> findAll();

    void deleteById(Long id);
}
