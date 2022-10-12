package ru.otus.springjpahibernate.repository.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.springjpahibernate.model.Genre;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@DataJpaTest
@Import(GenreRepositoryImpl.class)
class GenreRepositoryImplTest {

    @Autowired
    GenreRepositoryImpl genreRepository;

    @Test
    void add() {
        Genre genre = new Genre();
        genre.setName("dd");
        Genre actualGenre = genreRepository.add(genre);
        assertNotNull(actualGenre.getId());
    }

    @Test
    void findAll() {
        assertEquals(1, genreRepository.findAll().size());
    }

    @Test
    void deleteById() {
        genreRepository.deleteById(1l);
        assertEquals(0, genreRepository.findAll().size());
    }

    @Test
    void findById() {
        Genre genre = (Genre) genreRepository.findById(1l).get();
        assertNotNull(genre);
    }
}