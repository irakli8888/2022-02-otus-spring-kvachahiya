package ru.otus.springwebflux.migrations;


import com.mongodb.client.result.InsertManyResult;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import ru.otus.springwebflux.model.Author;
import ru.otus.springwebflux.model.Book;
import ru.otus.springwebflux.model.Genre;

import ru.otus.springwebflux.repository.AuthorRepository;
import ru.otus.springwebflux.repository.BookRepository;
import ru.otus.springwebflux.repository.GenreRepository;


@ChangeUnit(id = "1", order = "001")
public class DatabaseChangelog {

    @Execution()
    public void migrateAuthor(BookRepository bookRepository) {
        bookRepository.deleteAll();
        Genre genre = new Genre();
        Author author = new Author();
        genre.setName("genre");
        genre.setId(2l);
        author.setId(3L);
        author.setName("author");
        Book book = new Book();
        book.setName("book");
        book.setId(1l);
        book.setYearOfPublication(2012);
        book.setGenre(genre);
        book.setAuthor(author);
        bookRepository.insert(book);
    }

    @RollbackExecution
    public void rollback(BookRepository bookRepository, AuthorRepository authorRepository, GenreRepository genreRepository) {
        bookRepository.deleteAll();
        genreRepository.deleteAll();
        authorRepository.deleteAll();
    }

}
