package ru.otus.springdaojdbc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.springdaojdbc.service.GenreService;

@ShellComponent
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @ShellMethod("add genre")
    public void addGenre(@ShellOption(value = {"name", "n"}) String name){
        genreService.add(name);
    }

    @ShellMethod("show all genres")
    public void showGenres(){
        genreService.findAll();
    }

    @ShellMethod("delete author")
    public void deleteGenreById(@ShellOption(value = {"id"}) Long id){
        genreService.deleteById(id);
    }

}
