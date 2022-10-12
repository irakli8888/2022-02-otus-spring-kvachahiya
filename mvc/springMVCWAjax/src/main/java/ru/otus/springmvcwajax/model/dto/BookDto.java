package ru.otus.springmvcwajax.model.dto;

import lombok.Data;

@Data
public class BookDto {

    private Long id;

    private String name;

    private int yearOfPublication;

    private String genreName;

    private String authorName;
}
