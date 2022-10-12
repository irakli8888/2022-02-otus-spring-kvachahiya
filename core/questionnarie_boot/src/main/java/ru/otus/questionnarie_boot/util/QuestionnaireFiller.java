package ru.otus.questionnarie_boot.util;

import org.springframework.stereotype.Component;
import ru.otus.questionnarie_boot.domain.Answer;
import ru.otus.questionnarie_boot.domain.Question;
import ru.otus.questionnarie_boot.domain.Questionnaire;
import ru.otus.questionnarie_boot.domain.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IrklKvch
 */
@Component
public class QuestionnaireFiller implements Filler<Questionnaire>{

    @Override
    public List<Questionnaire> fill(String [] questStr) {
        List<Questionnaire> questionnaires = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();
        Question question = new Question(questStr[0]);
        for(int i = 1; i < questStr.length - 1; i++){
            Answer answer = new Answer(questStr[i]);
            answers.add(answer);
        }
        Response response = new Response(questStr[4]);
        Questionnaire questionnaire = new Questionnaire(answers, question, response);
        questionnaires.add(questionnaire);
        return questionnaires;
    }
}
