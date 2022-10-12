package ru.otus.springjpahibernate.controller;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.springjpahibernate.model.Book;
import ru.otus.springjpahibernate.model.Comment;
import ru.otus.springjpahibernate.service.BookCommentFacadeService;
import ru.otus.springjpahibernate.service.BookService;

import java.util.List;


@ShellComponent
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookCommentFacadeService bookCommentFacadeService;

    @ShellMethod("show all books")
    public void showBooks(){
        System.out.println("Books:");
        bookService
                .findAll()
                .forEach(System.out::println);
    }

    @ShellMethod("create book")
    public void createBook(@ShellOption(value = {"name", "n"}) String name,
                           @ShellOption(value = {"year_of_publication", "y"}) int yearOfPublication,
                           @ShellOption(value = {"genre_id", "g"}, defaultValue = "0") long genreId,
                           @ShellOption(value = {"author_id", "a"},defaultValue = "0") long authorId){
        Book book = bookService.createBook(name, yearOfPublication, genreId, authorId);
        System.out.println("Book created: "+ book.toString());
    }

    @ShellMethod("find book by id")
    public void findBookById(@ShellOption(value = {"id", "i"}) Long id){
        Book book = bookService.findById(id);
        System.out.println("Book found: " + book.toString());
    }

    @ShellMethod("delete book by id")
    public void deleteBookById(@ShellOption(value = {"id", "i"}) Long id){
        bookService.deleteById(id);
        System.out.println("Book with id = " + id + " has been deleted");
    }

    @ShellMethod("add comment to book")
    public void addCommentToBook(@ShellOption(value = {"text", "t"}) String text,
                                 @ShellOption(value = {"book_id", "bi"}, defaultValue = "0") long bookId){
        Comment comment = bookService.addComment(bookId, text);
        System.out.println("Comment has been created: " + comment.toString());
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @ShellMethod("show all comments by book")
    public void showBooksCommentsByBook(@ShellOption(value = {"id", "i"}) Long id){
        System.out.println("Books comments:");
        List<Comment> commentList = bookCommentFacadeService.showBooksCommentsByBook(id);
        commentList
                .forEach(System.out::println);
    }

}
