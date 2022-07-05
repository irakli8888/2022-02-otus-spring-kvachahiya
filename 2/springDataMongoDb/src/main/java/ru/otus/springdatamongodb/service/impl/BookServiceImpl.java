package ru.otus.springdatamongodb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.springdatamongodb.model.Book;
import ru.otus.springdatamongodb.model.Comment;
import ru.otus.springdatamongodb.repository.AuthorRepository;
import ru.otus.springdatamongodb.repository.BookRepository;
import ru.otus.springdatamongodb.repository.CommentRepository;
import ru.otus.springdatamongodb.repository.GenreRepository;
import ru.otus.springdatamongodb.service.BookService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;
    private final CommentRepository commentRepository;

    @Override
    public Book createBook(String name, int yearOfPublication, long genreId, long authorId) {
        Book book = new Book();
        try {
            book.setAuthor(authorRepository
                    .findById(authorId)
                    .orElseThrow(() -> new RuntimeException("author not found")));
            book.setGenre(genreRepository
                    .findById(genreId)
                    .orElseThrow(() -> new RuntimeException("author not found")));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        book.setName(name);
        book.setYearOfPublication(yearOfPublication);

        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        try {
            return (Book) bookRepository.findById(id).orElseThrow(() -> new RuntimeException("book not found"));
        } catch (Throwable e) {
            e.printStackTrace();
        };
        return null;
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Comment addComment(Long bookId, String text) {
        Book book = findById(bookId);
        Comment comment = new Comment();
        comment.setText(text);
        comment.setBook(book);
        book.getCommentList().add(comment);
        return commentRepository.save(comment);
    }
}
