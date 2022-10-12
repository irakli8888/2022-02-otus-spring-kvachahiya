package ru.otus.homework4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author IrklKvch
 */
@Component
@RequiredArgsConstructor
public class MessageLocalizationService {

    private final MessageSource messageSource;

    public String getStartMessage(){
       return messageSource.getMessage("The.beginning.of.the.test", new Object[0], Locale.getDefault());
    }

    public String getEnterNameMessage(){
        return messageSource.getMessage("Enter.your.name", new Object[0], Locale.getDefault());
    }

    public String getSelectAnswerMessage(){
        return messageSource.getMessage("Select.one.of.the.suggested.answers", new Object[0], Locale.getDefault());
    }

    public String getQuestionNumberMessage(){
        return messageSource.getMessage("Question.number", new Object[0], Locale.getDefault());
    }

    public String getOverTestMessage(){
        return messageSource.getMessage("The.test.is.over", new Object[0], Locale.getDefault());
    }

    public String getTotalQuestionMessage(){
        return messageSource.getMessage("Total.questions", new Object[0], Locale.getDefault());
    }

    public String getCorrectAnswersMessage(){
        return messageSource.getMessage("Correct.answers", new Object[0], Locale.getDefault());
    }

    public String getStudentMessage(){
        return messageSource.getMessage("Student", new Object[0], Locale.getDefault());
    }

    public String getPassedTestMessage(){
        return messageSource.getMessage("passed.the.test", new Object[0], Locale.getDefault());
    }

    public String getFailedTestMessage(){
        return messageSource.getMessage("failed.the.test", new Object[0], Locale.getDefault());
    }

    public String getNameNotEnteredMessage(){
        return messageSource.getMessage("name.not.entered", new Object[0], Locale.getDefault());
    }

}
