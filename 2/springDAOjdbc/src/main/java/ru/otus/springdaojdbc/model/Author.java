package ru.otus.springdaojdbc.model;

import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Author {
    private Long id;
    private String name;
    private String lastName;
}
