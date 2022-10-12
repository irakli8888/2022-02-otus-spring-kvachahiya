package ru.otus.homework4.service;

import org.springframework.shell.Availability;

public interface QuestionService {

    public void conductTest();

    void enterName(String name);

    Availability isNameEntered();
}
