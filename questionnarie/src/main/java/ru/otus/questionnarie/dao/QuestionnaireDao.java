package ru.otus.questionnarie.dao;

import ru.otus.questionnarie.domain.Questionnaire;

import java.util.List;

public interface QuestionnaireDao {

    void save(List<Questionnaire>questionnaires);
    List<Questionnaire> findAll();

}
