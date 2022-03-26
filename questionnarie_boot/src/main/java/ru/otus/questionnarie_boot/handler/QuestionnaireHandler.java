package ru.otus.questionnarie_boot.handler;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.otus.questionnarie_boot.domain.Questionnaire;

import java.util.List;

//имитация бд
@Getter
@Setter
@Component
public class QuestionnaireHandler {

    List<Questionnaire> questionnaires;
}
