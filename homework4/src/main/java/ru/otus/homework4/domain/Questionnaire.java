package ru.otus.homework4.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class Questionnaire {

    //ответы
    private final List<Answer> answers;
    //вопрос
    private final Question question;
    //верный ответ
    private final Response response;

}
