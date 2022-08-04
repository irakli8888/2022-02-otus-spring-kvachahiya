package ru.otus.springmvcwajax.service;

import ru.otus.springmvcwajax.model.Genre;

import java.util.List;

public interface GenreService {
    Genre add(String name);

    List<Genre> findAll();

    void deleteById(Long id);
}
