package ru.otus.springjpahibernate.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.springjpahibernate.model.Genre;
import ru.otus.springjpahibernate.repository.impl.GenreRepositoryImpl;
import ru.otus.springjpahibernate.service.GenreService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepositoryImpl genreRepository;

    @Override
    @Transactional
    public Genre add(String name) {
        Genre genre = new Genre();
        genre.setName(name);
        return genreRepository.add(genre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        genreRepository.deleteById(id);
    }
}
