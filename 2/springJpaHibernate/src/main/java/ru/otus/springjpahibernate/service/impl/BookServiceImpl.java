package ru.otus.springjpahibernate.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.springjpahibernate.model.Author;
import ru.otus.springjpahibernate.model.Book;
import ru.otus.springjpahibernate.model.Comment;
import ru.otus.springjpahibernate.model.Genre;
import ru.otus.springjpahibernate.repository.impl.AuthorRepositoryImpl;
import ru.otus.springjpahibernate.repository.impl.BookRepositoryImpl;
import ru.otus.springjpahibernate.repository.impl.CommentRepositoryImpl;
import ru.otus.springjpahibernate.repository.impl.GenreRepositoryImpl;
import ru.otus.springjpahibernate.service.BookService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final AuthorRepositoryImpl authorRepository;
    private final GenreRepositoryImpl genreRepository;
    private final BookRepositoryImpl bookRepository;
    private final CommentRepositoryImpl commentRepository;

    @Override
    @Transactional
    public Book createBook(String name, int yearOfPublication, long genreId, long authorId) {
        Book book = new Book();
        try {
            book.setAuthor((Author) authorRepository
                    .findById(authorId)
                    .orElseThrow(() -> new RuntimeException("author not found")));
            book.setGenre((Genre) genreRepository
                    .findById(genreId)
                    .orElseThrow(() -> new RuntimeException("author not found")));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        book.setName(name);
        book.setYearOfPublication(yearOfPublication);

        return bookRepository.add(book);
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
    @Transactional
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Comment addComment(Long bookId,String text) {
        Book book = findById(bookId);
        Comment comment = new Comment();
        comment.setText(text);
        comment.setBook(book);
        book.getCommentList().add(comment);
        return commentRepository.add(comment);
    }
}
