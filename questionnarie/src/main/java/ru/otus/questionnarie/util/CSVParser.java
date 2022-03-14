package ru.otus.questionnarie.util;

import au.com.bytecode.opencsv.CSVReader;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.otus.questionnarie.dao.QuestionnaireDao;
import ru.otus.questionnarie.domain.Questionnaire;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class CSVParser {

    private final QuestionnaireDao questionnaireDao;
    private final QuestionnaireFiller questionnaireFiller;

    @Value("${csv.file.path}")
    private String filepath;

    public void parse(){
        List<Questionnaire> questionnaires = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(new File(filepath)), ';', '"', 1);
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                questionnaires.addAll(questionnaireFiller.fill(nextLine));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        questionnaireDao.save(questionnaires);
    }
}
