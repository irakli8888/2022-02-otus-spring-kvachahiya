package ru.otus.springdaojdbc.model;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {
    private Long id;
    private String name;
    private int yearOfPublication;
    private Genre genre;
    private Author author;
}
