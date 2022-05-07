package ru.otus.springjpahibernate.service;

import ru.otus.springjpahibernate.model.Book;
import ru.otus.springjpahibernate.model.Comment;

import java.util.List;

public interface BookService {
    Book createBook(String name, int yearOfPublication, long genreId, long authorId);

    List<Book> findAll();

    Book findById(Long id);

    void deleteById(Long id);

    Comment addComment(Long bookId, String comment);


}
