package ru.otus.questionnarie_boot.dao;

import ru.otus.questionnarie_boot.domain.Questionnaire;

import java.util.List;

public interface QuestionnaireDao {

    void save(List<Questionnaire>questionnaires);
    List<Questionnaire> findAll();

}
