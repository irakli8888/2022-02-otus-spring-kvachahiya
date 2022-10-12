package ru.otus.homework4.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import ru.otus.homework4.service.QuestionService;

@ShellComponent
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @ShellMethod(key = "enter-name", value = "enter your name")
    public void enterName(@ShellOption(value = {"name", "n"}, defaultValue = "anon") String username){
         questionService.enterName(username);
    }

    @ShellMethod(key = "conduct-test", value = "conduct test")
    @ShellMethodAvailability(value = "isNameEntered")
    public void conductTest(){
        questionService.conductTest();
    }

    private Availability isNameEntered(){
        return questionService.isNameEntered();
    }


}
