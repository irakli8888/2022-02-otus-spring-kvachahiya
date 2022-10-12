package dao;

import domain.Questionnaire;
import handler.QuestionnaireHandler;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
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
