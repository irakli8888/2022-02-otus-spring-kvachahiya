package ru.otus.questionnarie;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.questionnarie.service.QuestionService;
import ru.otus.questionnarie.service.QuestionServiceImpl;
import ru.otus.questionnarie.util.CSVParser;

@ComponentScan
@Configuration
@RequiredArgsConstructor
public class QuestionnarieApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(QuestionnarieApplication.class);
        QuestionService questionService = context.getBean(QuestionServiceImpl.class);
        CSVParser parser = context.getBean(CSVParser.class);
        parser.parse();
        questionService.conductTest();
    }
}
