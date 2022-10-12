package ru.otus.questionnarie.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.File;

@Configuration
@PropertySource("classpath:application.properties")
public class QuestionnarieConfig {

    @Value("${csv.file.path}")
    private String filepath;

    @Bean
    public File getCSVFile(){
        return new File(filepath);
    }
}
