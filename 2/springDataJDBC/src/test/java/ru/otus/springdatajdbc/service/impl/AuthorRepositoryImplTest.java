package ru.otus.springdatajdbc.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import ru.otus.springdatajdbc.model.Author;
import ru.otus.springdatajdbc.service.AuthorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@DataJpaTest
@Import({AuthorServiceImpl.class})
class AuthorRepositoryImplTest {

    @Autowired
    AuthorService authorService;

    @Test
    void add() {
        Author actualAuthor = authorService.addAuthor("ss","ss");
        assertNotNull(actualAuthor.getId(), "author not added");
    }

    @Test
    void findAll() {
        assertEquals(1, authorService.findAll().size());
    }

}