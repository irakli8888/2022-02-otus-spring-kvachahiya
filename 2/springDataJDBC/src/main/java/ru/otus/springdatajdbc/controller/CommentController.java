package ru.otus.springdatajdbc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.springdatajdbc.service.CommentService;

@ShellComponent
@RequiredArgsConstructor
public class CommentController{

    private final CommentService commentService;

    @ShellMethod("show all books")
    public void showComments(){
        commentService.findAll().forEach(System.out::println);
    }


    @ShellMethod("show all comments by book")
    public void showCommentsByBook(@ShellOption(value = {"id", "i"}) Long id){
        System.out.println("Books comments:");
        commentService.findByBookId(id).forEach(System.out::println);
    }
}
