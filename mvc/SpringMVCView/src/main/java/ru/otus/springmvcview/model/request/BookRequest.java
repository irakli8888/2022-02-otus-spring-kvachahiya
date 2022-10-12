package ru.otus.springmvcview.model.request;

import lombok.Data;

@Data
public class BookRequest {
    private Long id;

    private String name;

    private int yearOfPublication;

    private Long genreId;

    private Long authorId;
}
