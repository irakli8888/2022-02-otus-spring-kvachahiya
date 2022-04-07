package ru.otus.homework4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.homework4.service.QuestionService;
import ru.otus.homework4.util.CustomParser;

@SpringBootApplication
public class Homework4Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Homework4Application.class, args);
//        ctx.getBean(CustomParser.class).parse();
//        ctx.getBean(QuestionService.class).conductTest();
    }

}
