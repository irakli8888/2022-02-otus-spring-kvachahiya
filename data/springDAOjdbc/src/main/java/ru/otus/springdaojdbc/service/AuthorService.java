package ru.otus.springdaojdbc.service;

public interface AuthorService {
    void showAll();

    void addAuthor(String name, String lastname);

    void deleteById(Long id);
}
