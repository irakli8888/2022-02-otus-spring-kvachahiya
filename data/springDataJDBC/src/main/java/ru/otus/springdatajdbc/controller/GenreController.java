package ru.otus.springdatajdbc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.springdatajdbc.model.Genre;
import ru.otus.springdatajdbc.service.GenreService;

@ShellComponent
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @ShellMethod("add genre")
    public void addGenre(@ShellOption(value = {"name", "n"}) String name){
        Genre genre = genreService.add(name);
        System.out.println("Genre has been created:" + genre);
    }

    @ShellMethod("show all genres")
    public void showGenres(){
        System.out.println("Genres: ");
        genreService.findAll().forEach(System.out::println);
    }

    @ShellMethod("delete author")
    public void deleteGenreById(@ShellOption(value = {"id"}) Long id){
        genreService.deleteById(id);
        System.out.println("Genre has with id = " + id + "been deleted");
    }

}
