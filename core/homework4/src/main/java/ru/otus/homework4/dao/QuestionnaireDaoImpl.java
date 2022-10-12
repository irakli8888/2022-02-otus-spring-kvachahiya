package ru.otus.homework4.dao;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.homework4.domain.Questionnaire;
import ru.otus.homework4.handler.QuestionnaireHandler;

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
