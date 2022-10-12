package ru.otus.springjpahibernate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.springjpahibernate.service.CommentService;

@ShellComponent
@RequiredArgsConstructor
public class CommentController{

    private final CommentService commentService;

    @ShellMethod("show all books")
    public void showComments(){
        commentService.findAll().forEach(System.out::println);
    }
}
