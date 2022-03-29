package ru.otus.questionnarie_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.questionnarie_boot.service.QuestionService;
import ru.otus.questionnarie_boot.util.CustomParser;


@SpringBootApplication
public class QuestionnarieBootApplication {

    public static void main(String[] args) {
        ApplicationContext ctx =SpringApplication.run(QuestionnarieBootApplication.class, args);
        ctx.getBean(CustomParser.class).parse();
        ctx.getBean(QuestionService.class).conductTest();
    }

}
