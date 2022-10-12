package util;

import au.com.bytecode.opencsv.CSVReader;
import dao.QuestionnaireDao;
import dao.QuestionnaireDaoImpl;
import domain.Answer;
import domain.Question;
import domain.Questionnaire;
import domain.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@RequiredArgsConstructor
public class CSVParser {

    private final Resource resource;
    private final QuestionnaireDao questionnaireDao;


    public void parse(){
        List<Questionnaire> questionnaires = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(resource.getFile()), ';', '"', 1);
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
