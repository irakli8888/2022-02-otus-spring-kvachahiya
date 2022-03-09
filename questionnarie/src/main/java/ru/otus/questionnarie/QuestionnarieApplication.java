package ru.otus.questionnarie;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.questionnarie.service.QuestionService;
import ru.otus.questionnarie.service.QuestionServiceImpl;

@ComponentScan
@Configuration
@RequiredArgsConstructor
public class QuestionnarieApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(QuestionnarieApplication.class);
        QuestionService questionService = context.getBean(QuestionServiceImpl.class);
        questionService.conductTest();


    }

}
