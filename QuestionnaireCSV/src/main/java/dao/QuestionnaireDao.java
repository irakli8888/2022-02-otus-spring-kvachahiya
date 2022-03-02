package dao;

import domain.Answer;
import domain.Questionnaire;

import java.util.List;

public interface QuestionnaireDao {

    public void save(List<Questionnaire>questionnaires);
    public List<Questionnaire> findAll();

}
