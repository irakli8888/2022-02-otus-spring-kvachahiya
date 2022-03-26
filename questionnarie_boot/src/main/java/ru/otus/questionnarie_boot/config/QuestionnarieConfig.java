package ru.otus.questionnarie_boot.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class QuestionnarieConfig {

    @Value("${csv.file.path}")
    private String filepath_en;

    @Value("${csv.file.path.ru}")
    private String filepath_ru;


    @Bean(name = "filepath")
    @ConditionalOnProperty(value = "language.en")
    public String filepathEng(){
        return filepath_en;
    }

    @Bean(name = "filepath")
    @ConditionalOnProperty(value = "language.ru")
    public String filepathRu(){
        return filepath_ru;
    }
}
