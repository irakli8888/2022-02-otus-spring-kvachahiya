package ru.otus.springmvcview.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.springmvcview.model.Book;
import ru.otus.springmvcview.model.Comment;
import ru.otus.springmvcview.model.request.BookRequest;
import ru.otus.springmvcview.repository.AuthorRepository;
import ru.otus.springmvcview.repository.BookRepository;
import ru.otus.springmvcview.repository.CommentRepository;
import ru.otus.springmvcview.repository.GenreRepository;
import ru.otus.springmvcview.service.BookService;

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

    @Override
    public Book edit(BookRequest bookRequest) {
        Book book = bookRepository
                .findById(bookRequest.getId())
                .orElseThrow(()-> new RuntimeException("book not found"));
        book.setAuthor(authorRepository.findById(bookRequest.getAuthorId())
                        .orElseThrow(()-> new RuntimeException("author not found")));
        book.setGenre(genreRepository.findById(bookRequest.getGenreId())
                .orElseThrow(()-> new RuntimeException("genre not found")));
        book.setName(bookRequest.getName());
        return bookRepository.save(book);
    }
}
