package ru.otus.springdaojdbc.dao.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.springdaojdbc.model.Genre;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Dao для работы с жанрами")
@Import(GenreDaoJdbc.class)
@JdbcTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class GenreDaoJdbcTest {

    @Autowired
    private GenreDaoJdbc genreDaoJdbc;

    @Test
    void add() {
        Genre genre = new Genre();
        genre.setName("1");
        Genre expectedGenre = genreDaoJdbc.add(genre);
        assertNotNull(expectedGenre.getId());
    }

    @Test
    void findAll() {
        List<Genre> genreList = genreDaoJdbc.findAll();
        assertEquals(1, genreList.size());
    }

    @Test
    void deleteById() {
        genreDaoJdbc.deleteById(1l);
        List<Genre> genreList = genreDaoJdbc.findAll();
        assertEquals(0, genreList.size());
    }

    @Test
    void findById() {
        Genre genre = new Genre(1l, "sss");
        assertEquals(genreDaoJdbc.findById(1l), genre);
    }
}