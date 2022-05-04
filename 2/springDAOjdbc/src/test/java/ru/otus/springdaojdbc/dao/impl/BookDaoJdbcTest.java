package ru.otus.springdaojdbc.dao.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.springdaojdbc.model.Author;
import ru.otus.springdaojdbc.model.Book;
import ru.otus.springdaojdbc.model.Genre;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Dao для работы с книгами")
@Import(BookDaoJdbc.class)
@JdbcTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class BookDaoJdbcTest {

    @Autowired
    private BookDaoJdbc bookDaoJdbc;

    @Test
    void add() {
        Book book = new Book();
        book.setName("1");
        book.setYearOfPublication(2021);
        Author author = new Author();
        author.setName("1");
        author.setLastName("2");
        Genre genre = new Genre();
        genre.setName("1");
        book.setAuthor(author);
        book.setGenre(genre);
        Book expectedBook = bookDaoJdbc.add(book);
        assertNotNull(expectedBook);
    }

    @Test
    void findAll() {
        List<Book> bookList = bookDaoJdbc.findAll();
        assertEquals(3, bookList.size());
    }

    @Test
    void deleteById() {
        bookDaoJdbc.deleteById(1l);
        List<Book> authorList = bookDaoJdbc.findAll();
        assertEquals(2, authorList.size());
    }

    @Test
    void findById() {
        assertEquals(bookDaoJdbc.findById(1l).getName(), "sss");
    }
}