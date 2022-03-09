package handler;

import domain.Questionnaire;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//имитация бд
@Getter
@Setter
public class QuestionnaireHandler {

    List<Questionnaire> questionnaires;
}
