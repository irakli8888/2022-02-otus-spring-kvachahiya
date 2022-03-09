package service;

import dao.QuestionnaireDao;
import domain.Questionnaire;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Scanner;


@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService{

    private final QuestionnaireDao questionnaireDao;

    @Override
    public void conductTest() {
        int correctAnswer = 0;
        List<Questionnaire> questionnaires = questionnaireDao.findAll();
        int questionCount = questionnaires.size();
        System.out.println("The beginning of the test\nSelect one of the suggested answers");
        for (int i = 0; i < questionnaires.size(); i++){
            int numberOfQuestion = i + 1;
            Questionnaire questionnaire = questionnaires.get(i);
            System.out.println("Question №" + numberOfQuestion + ": \n" + questionnaire.getQuestion().getQuestionValue());
            for (int j = 0; j < questionnaire.getAnswers().size(); j++){
                int number = j + 1;
                System.out.println(number + ") " + questionnaire.getAnswers().get(j).getAnswer());
            }
            Scanner scanner = new Scanner(System.in);
            int selectedValue = scanner.nextInt();
            if (questionnaire.getAnswers().get(selectedValue - 1).getAnswer().equals(questionnaire.getResponse().getResponse())){
                correctAnswer++;
            }
        }
        System.out.println("The test is over\nTotal questions: "+ questionCount + "\nCorrect answers: "+ correctAnswer);
    }
}
