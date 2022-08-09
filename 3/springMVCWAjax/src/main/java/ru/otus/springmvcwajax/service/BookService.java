package ru.otus.springmvcwajax.service;



import ru.otus.springmvcwajax.model.Book;
import ru.otus.springmvcwajax.model.Comment;
import ru.otus.springmvcwajax.model.dto.BookDto;
import ru.otus.springmvcwajax.model.request.BookRequest;

import java.util.List;

public interface BookService {
    Book createBook(String name, int yearOfPublication, long genreId, long authorId);

    List<BookDto> findAll();

    Book findById(Long id);

    void deleteById(Long id);

    Comment addComment(Long bookId, String comment);


    Book edit(BookRequest bookRequest);
}
