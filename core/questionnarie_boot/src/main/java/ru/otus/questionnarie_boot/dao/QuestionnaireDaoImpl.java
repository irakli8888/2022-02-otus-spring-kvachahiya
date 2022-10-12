package ru.otus.questionnarie_boot.dao;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.questionnarie_boot.domain.Questionnaire;
import ru.otus.questionnarie_boot.handler.QuestionnaireHandler;

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
