package ru.otus.springdaojdbc.dao.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.springdaojdbc.model.Author;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DisplayName("Dao для работы с авторами")
@Import(AuthorDaoJdbc.class)
@JdbcTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AuthorDaoJdbcTest {

    @Autowired
    private AuthorDaoJdbc authorDaoJdbc;

    @Test
    void add(){
        Author author = new Author();
        author.setName("1");
        author.setLastName("2");
        Author expectedAuthor = authorDaoJdbc.add(author);
        assertNotNull(expectedAuthor.getId());
    }


    @Test
    void delete() {
        authorDaoJdbc.deleteById(1l);
        List<Author> authorList = authorDaoJdbc.findAll();
        assertEquals(0, authorList.size());
    }

    @Test
    void findAll() {
        List<Author> authorList = authorDaoJdbc.findAll();
        assertEquals(1, authorList.size());
    }

    @Test
    void findById() {
        Author author = new Author(1l, "ir","ss");
        assertEquals(authorDaoJdbc.findById(1l), author);
    }
}