package ru.otus.questionnarie.util;

import au.com.bytecode.opencsv.CSVReader;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import ru.otus.questionnarie.dao.QuestionnaireDao;
import ru.otus.questionnarie.domain.Answer;
import ru.otus.questionnarie.domain.Question;
import ru.otus.questionnarie.domain.Questionnaire;
import ru.otus.questionnarie.domain.Response;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class CSVParser {

    private final QuestionnaireDao questionnaireDao;

    @Value("${csv.file.path}")
    private String filepath;

    @PostConstruct
    public void parse(){
        List<Questionnaire> questionnaires = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(new File(filepath)), ';', '"', 1);
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine != null) {
                    List<Answer> answers = new ArrayList<>();
                    Question question = new Question(nextLine[0]);
                    for(int i = 1; i < nextLine.length - 1; i++){
                        Answer answer = new Answer(nextLine[i]);
                        answers.add(answer);
                    }
                    Response response = new Response(nextLine[4]);
                    Questionnaire questionnaire = new Questionnaire(answers, question, response);
                    questionnaires.add(questionnaire);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        questionnaireDao.save(questionnaires);
    }
}
