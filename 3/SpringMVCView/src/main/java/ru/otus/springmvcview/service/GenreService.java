package ru.otus.springmvcview.service;

import ru.otus.springmvcview.model.Genre;

import java.util.List;

public interface GenreService {
    Genre add(String name);

    List<Genre> findAll();

    void deleteById(Long id);
}
