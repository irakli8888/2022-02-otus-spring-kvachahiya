package ru.otus.springdaojdbc.model;

import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {
    private Long id;
    private String name;
    private String lastName;
}
