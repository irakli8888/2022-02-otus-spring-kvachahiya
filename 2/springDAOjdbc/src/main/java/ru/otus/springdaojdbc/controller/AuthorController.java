package ru.otus.springdaojdbc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.springdaojdbc.service.AuthorService;



@ShellComponent
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @ShellMethod("show authors")
    public void showAuthors() {
        authorService.showAll();
    }

    @ShellMethod("add author")
    public void addAuthor(@ShellOption(value = {"name", "n"}) String name
            , @ShellOption(value = {"lastname", "l"}) String lastname){
        authorService.addAuthor(name, lastname);
    }

    @ShellMethod("delete author")
    public void deleteAuthor(@ShellOption(value = {"id"}) Long id){
        authorService.deleteById(id);
    }
}
