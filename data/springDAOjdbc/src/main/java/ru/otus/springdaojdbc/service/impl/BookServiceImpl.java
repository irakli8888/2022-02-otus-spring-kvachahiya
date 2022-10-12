package ru.otus.springdaojdbc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.springdaojdbc.dao.impl.AuthorDaoJdbc;
import ru.otus.springdaojdbc.dao.impl.BookDaoJdbc;
import ru.otus.springdaojdbc.dao.impl.GenreDaoJdbc;
import ru.otus.springdaojdbc.model.Author;
import ru.otus.springdaojdbc.model.Book;
import ru.otus.springdaojdbc.model.Genre;
import ru.otus.springdaojdbc.service.BookService;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookDaoJdbc bookDaoJdbc;
    private final GenreDaoJdbc genreDaoJdbc;
    private final AuthorDaoJdbc authorDaoJdbc;

    @Override
    public void findAll(){
        bookDaoJdbc.findAll().forEach(book-> System.out.println(book.toString()));
    }

    @Override
    public void createBook(String name,
                           int yearOfPublication,
                           long genreId,
                           long authorId) {
        Book book = new Book();
        if (genreId != 0) {
            Genre genre = genreDaoJdbc.findById(genreId);
            book.setGenre(genre);
        }
        if (authorId != 0) {
            Author author = authorDaoJdbc.findById(authorId);
            book.setAuthor(author);
            book.setYearOfPublication(yearOfPublication);
            book.setName(name);
            bookDaoJdbc.add(book);
        }
    }

    @Override
    public void findById(Long id) {
        System.out.println(bookDaoJdbc.findById(id));
    }

    @Override
    public void deleteById(Long id) {
        bookDaoJdbc.deleteById(id);
    }
}
