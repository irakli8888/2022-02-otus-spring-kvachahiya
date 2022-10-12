package ru.otus.questionnarie.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.questionnarie.dao.QuestionnaireDao;
import ru.otus.questionnarie.domain.Questionnaire;


import java.util.List;
import java.util.Scanner;


@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService{

    private final QuestionnaireDao questionnaireDao;
    @Value("${threshold.for.offsetting}")
    private int thresholdForOffsetting;

    @Override
    public void conductTest() {
        int correctAnswer = 0;
        List<Questionnaire> questionnaires = questionnaireDao.findAll();
        int questionCount = questionnaires.size();
        System.out.println("Enter your name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("The beginning of the test\nSelect one of the suggested answers");
        for (int i = 0; i < questionnaires.size(); i++){
            int numberOfQuestion = i + 1;
            Questionnaire questionnaire = questionnaires.get(i);
            System.out.println("Question №" + numberOfQuestion + ": \n" + questionnaire.getQuestion().getQuestionValue());
            for (int j = 0; j < questionnaire.getAnswers().size(); j++){
                int number = j + 1;
                System.out.println(number + ") " + questionnaire.getAnswers().get(j).getAnswer());
            }
            int selectedValue = scanner.nextInt();
            if (questionnaire.getAnswers().get(selectedValue - 1).getAnswer().equals(questionnaire.getResponse().getResponse())){
                correctAnswer++;
            }
        }
        System.out.println("The test is over\nTotal questions: "+ questionCount + "\nCorrect answers: "+ correctAnswer);
        if(correctAnswer >= thresholdForOffsetting){
            System.out.println("Student " + name + " passed the test");
        }else {
            System.out.println("Student " + name + " failed the test");
        }
    }
}
