package ru.otus.springmvcview.service;



import ru.otus.springmvcview.model.Book;
import ru.otus.springmvcview.model.Comment;
import ru.otus.springmvcview.model.request.BookRequest;

import java.util.List;

public interface BookService {
    Book createBook(String name, int yearOfPublication, long genreId, long authorId);

    List<Book> findAll();

    Book findById(Long id);

    void deleteById(Long id);

    Comment addComment(Long bookId, String comment);


    Book edit(BookRequest bookRequest);
}
