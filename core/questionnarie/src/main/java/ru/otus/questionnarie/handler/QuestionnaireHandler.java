package ru.otus.questionnarie.handler;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.otus.questionnarie.domain.Questionnaire;

import java.util.List;

//имитация бд
@Getter
@Setter
@Component
public class QuestionnaireHandler {

    List<Questionnaire> questionnaires;
}
