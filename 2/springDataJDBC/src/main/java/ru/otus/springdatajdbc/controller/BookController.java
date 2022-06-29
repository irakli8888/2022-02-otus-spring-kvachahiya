package ru.otus.springdatajdbc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.springdatajdbc.model.Book;
import ru.otus.springdatajdbc.model.Comment;
import ru.otus.springdatajdbc.service.BookService;

@ShellComponent
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

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



}
