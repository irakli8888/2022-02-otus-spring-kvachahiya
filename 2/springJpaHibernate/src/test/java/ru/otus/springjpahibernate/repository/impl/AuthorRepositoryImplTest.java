package ru.otus.springjpahibernate.repository.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.springjpahibernate.model.Author;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@DataJpaTest
@Import(AuthorRepositoryImpl.class)
class AuthorRepositoryImplTest {

    @Autowired
    AuthorRepositoryImpl authorRepository;

    @Test
    void add() {
        Author author = new Author();
        author.setLastName("ss");
        author.setName("ss");
        Author actualAuthor = authorRepository.add(author);
        assertNotNull(actualAuthor.getId(), "author nor added");
    }

    @Test
    void findAll() {
        assertEquals(1, authorRepository.findAll().size());
    }

    @Test
    void deleteById() {
        authorRepository.deleteById(1l);
        assertEquals(0, authorRepository.findAll().size());
    }

    @Test
    void findById() {
        Author author = (Author) authorRepository.findById(1l).get();
        assertNotNull(author);
    }
}