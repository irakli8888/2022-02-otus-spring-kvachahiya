package ru.otus.questionnarie.dao;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.questionnarie.domain.Questionnaire;
import ru.otus.questionnarie.handler.QuestionnaireHandler;

import java.util.List;

@RequiredArgsConstructor
@Component
public class QuestionnaireDaoImpl implements QuestionnaireDao{

    private final QuestionnaireHandler questionnaireHandler;

    @Override
    public void save(List<Questionnaire> questionnaires) {
        questionnaireHandler.setQuestionnaires(questionnaires);
    }

    @Override
    public List<Questionnaire> findAll() {
        return questionnaireHandler.getQuestionnaires();
    }

}
