package ru.otus.homework4.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import ru.otus.homework4.domain.Answer;
import ru.otus.homework4.domain.Question;
import ru.otus.homework4.domain.Questionnaire;
import ru.otus.homework4.domain.Response;
import ru.otus.homework4.handler.QuestionnaireHandler;

import java.util.ArrayList;
import java.util.List;



@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
class CSVParserTest {

    @Autowired
    private CSVParser csvParser;
    @Autowired
    private QuestionnaireHandler questionnaireHandler;
    private static List<Questionnaire> questionnaires = new ArrayList<>();
    private static String text =
            "сколько стоит гречка;100;500;30;100\n" +
                    "возникновение Христианства на Руси;988;889;956;988\n" +
                    "какой по счету Наруто хокаге;4;7;6;7\n" +
                    "сколько лет сергею звереву;45;58;134;58\n" +
                    "год выхода первой версии java;1992;1998;1996;1996";

    @BeforeAll
    static void setUp() {
        String csvMas[] = text.split("\n");
        for(int i = 0; i < csvMas.length; i++){
            String[] csvLine = csvMas[i].split(";");
            List<Answer> answers = new ArrayList<>();
            Question question = new Question(csvLine[0]);
            for(int x = 1; x < csvLine.length - 1; x++){
                Answer answer = new Answer(csvLine[x]);
                answers.add(answer);
            }
            Response response = new Response(csvLine[4]);
            Questionnaire questionnaire = new Questionnaire(answers, question, response);
            questionnaires.add(questionnaire);
        }

    }

    @Test
    void parseTest() {
        csvParser.parse();
        Assertions.assertIterableEquals(questionnaires, questionnaireHandler.getQuestionnaires());
    }
}