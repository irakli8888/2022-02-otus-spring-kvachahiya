package ru.otus.homework4.dao;

import ru.otus.homework4.domain.Questionnaire;

import java.util.List;

public interface QuestionnaireDao {

    void save(List<Questionnaire>questionnaires);
    List<Questionnaire> findAll();

}
