package ru.otus.homework4.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.shell.Availability;
import org.springframework.stereotype.Service;
import ru.otus.homework4.dao.QuestionnaireDao;
import ru.otus.homework4.domain.Questionnaire;
import ru.otus.homework4.handler.StudentHandler;
import ru.otus.homework4.util.CustomParser;

import java.util.List;
import java.util.Scanner;


@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService{

    private final QuestionnaireDao questionnaireDao;
    @Value("${threshold.for.offsetting}")
    private int thresholdForOffsetting;
    private final MessageLocalizationService messages;
    private final StudentHandler studentHandler;
    private final CustomParser customParser;

    @Override
    public void conductTest() {
        parseCsvFile();
        int correctAnswer = 0;
        List<Questionnaire> questionnaires = questionnaireDao.findAll();
        int questionCount = questionnaires.size();
        Scanner scanner = new Scanner(System.in);
        System.out.println(messages.getStartMessage() + "\n" + messages.getSelectAnswerMessage());
        for (int i = 0; i < questionnaires.size(); i++){
            int numberOfQuestion = i + 1;
            Questionnaire questionnaire = questionnaires.get(i);
            System.out.println(messages.getQuestionNumberMessage() + numberOfQuestion + ": \n" + questionnaire.getQuestion().getQuestionValue());
            for (int j = 0; j < questionnaire.getAnswers().size(); j++){
                int number = j + 1;
                System.out.println(number + ") " + questionnaire.getAnswers().get(j).getAnswer());
            }
            int selectedValue = scanner.nextInt();
            if (questionnaire.getAnswers().get(selectedValue - 1).getAnswer().equals(questionnaire.getResponse().getResponse())){
                correctAnswer++;
            }
        }
        System.out.println(messages.getOverTestMessage() +
                "\n" + messages.getTotalQuestionMessage()+ ": "+ questionCount + "\n" + messages.getCorrectAnswersMessage() + ": "+ correctAnswer);
        if(correctAnswer >= thresholdForOffsetting){
            System.out.println(messages.getStudentMessage() +  " " + studentHandler.getName() + " " + messages.getPassedTestMessage());
        }else {
            System.out.println(messages.getStudentMessage() +  " " + studentHandler.getName() + " " + messages.getFailedTestMessage());
        }
    }

    private void parseCsvFile(){
        customParser.parse();
    }

    @Override
    public void enterName(String name){
        studentHandler.setName(name);
    }

    @Override
    public Availability isNameEntered() {
        return studentHandler.getName() == null ?
                Availability.unavailable("name not entered") : Availability.available();
    }
}
