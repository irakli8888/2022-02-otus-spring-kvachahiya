package ru.otus.springdaojdbc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.springdaojdbc.service.BookService;

@ShellComponent
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @ShellMethod("show all books")
    public void showBooks(){
        bookService.findAll();
    }

    @ShellMethod("create book")
    public void createBook(@ShellOption(value = {"name", "n"}) String name,
                           @ShellOption(value = {"year_of_publication", "y"}) int yearOfPublication,
                           @ShellOption(value = {"genre_id", "g"}, defaultValue = "0") long genreId,
                           @ShellOption(value = {"author_id", "a"},defaultValue = "0") long authorId){
        bookService.createBook(name, yearOfPublication, genreId, authorId);
    }

    @ShellMethod("find book by id")
    public void findBookById(@ShellOption(value = {"id", "i"}) Long id){
        bookService.findById(id);
    }

    @ShellMethod("delete book by id")
    public void deleteBookById(@ShellOption(value = {"id", "i"}) Long id){
        bookService.deleteById(id);
    }

}
