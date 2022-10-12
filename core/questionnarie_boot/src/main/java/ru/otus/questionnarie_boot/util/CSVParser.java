package ru.otus.questionnarie_boot.util;

import au.com.bytecode.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.otus.questionnarie_boot.dao.QuestionnaireDao;
import ru.otus.questionnarie_boot.domain.Questionnaire;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class CSVParser implements CustomParser{

    private final QuestionnaireDao questionnaireDao;
    private final QuestionnaireFiller questionnaireFiller;
    @Qualifier("filepath")
    @Autowired
    private final String filepath;

    @Override
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
