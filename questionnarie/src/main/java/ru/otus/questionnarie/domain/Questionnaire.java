package ru.otus.questionnarie.domain;

import lombok.*;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Questionnaire {

    //ответы
    private final List<Answer> answers;
    //вопрос
    private final Question question;
    //верный ответ
    private final Response response;

}
