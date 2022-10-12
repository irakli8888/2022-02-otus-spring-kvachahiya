package ru.otus.springjpahibernate.repository.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.springjpahibernate.model.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@DataJpaTest
@Import(BookRepositoryImpl.class)
class BookRepositoryImplTest {

    @Autowired
    BookRepositoryImpl bookRepository;

    @Test
    void add() {
        Book book = new Book();
        book.setName("ss");
        book.setYearOfPublication(2012);
        Book actualBook = bookRepository.add(book);
        assertNotNull(actualBook);
    }

    @Test
    void findAll() {
        assertEquals(3, bookRepository.findAll().size());
    }

    @Test
    void deleteById() {
        bookRepository.deleteById(1l);
        assertEquals(2, bookRepository.findAll().size());
    }

    @Test
    void findById() {
        Book book = (Book) bookRepository.findById(1l).get();
        assertNotNull(book);
    }
}