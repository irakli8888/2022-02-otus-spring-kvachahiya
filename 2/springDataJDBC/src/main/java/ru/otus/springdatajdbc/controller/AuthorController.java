package ru.otus.springdatajdbc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.springdatajdbc.model.Author;
import ru.otus.springdatajdbc.service.AuthorService;


@ShellComponent
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @ShellMethod("show authors")
    public void showAuthors() {
        System.out.println("Authors: ");
        authorService
                .findAll()
                .forEach(System.out::println);
    }

    @ShellMethod("add author")
    public void addAuthor(@ShellOption(value = {"name", "n"}) String name
            , @ShellOption(value = {"lastname", "l"}) String lastname) {
        Author author = authorService.addAuthor(name, lastname);
        System.out.println("author created: " + author.toString());
    }

    @ShellMethod("delete author")
    public void deleteAuthor(@ShellOption(value = {"id"}) Long id) {
        authorService.deleteById(id);
        System.out.println("author with id = " + id + " has been deleted");
    }
}
