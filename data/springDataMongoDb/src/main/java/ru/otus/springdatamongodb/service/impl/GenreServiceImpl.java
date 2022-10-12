package ru.otus.springdatamongodb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.springdatamongodb.model.Genre;
import ru.otus.springdatamongodb.repository.GenreRepository;
import ru.otus.springdatamongodb.service.GenreService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public Genre add(String name) {
        Genre genre = new Genre();
        genre.setName(name);
        return genreRepository.save(genre);
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        genreRepository.deleteById(id);
    }
}
