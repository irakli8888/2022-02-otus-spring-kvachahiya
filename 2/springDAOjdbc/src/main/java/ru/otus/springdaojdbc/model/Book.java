package ru.otus.springdaojdbc.model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    private Long id;
    private String name;
    private int yearOfPublication;
    private Genre genre;
    private Author author;
}
