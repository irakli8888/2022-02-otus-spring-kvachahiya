package ru.otus.questionnarie_boot.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.questionnarie_boot.dao.QuestionnaireDao;
import ru.otus.questionnarie_boot.domain.Questionnaire;
import ru.otus.questionnarie_boot.util.Messages;

import java.util.List;
import java.util.Scanner;


@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService{

    private final QuestionnaireDao questionnaireDao;
    @Value("${threshold.for.offsetting}")
    private int thresholdForOffsetting;
    private final Messages messages;

    @Override
    public void conductTest() {
        int correctAnswer = 0;
        List<Questionnaire> questionnaires = questionnaireDao.findAll();
        int questionCount = questionnaires.size();
        System.out.println(messages.getEnterNameMessage());
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println(messages.getStartMessage());
        System.out.println(messages.getSelectAnswerMessage());
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
            System.out.println(messages.getStudentMessage() +  " " + name + " " + messages.getPassedTestMessage());
        }else {
            System.out.println(messages.getStudentMessage() +  " " + name + " " + messages.getFailedTestMessage());
        }
    }
}
