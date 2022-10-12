package ru.otus.springdaojdbc.service;

public interface BookService {
    void findAll();

    void createBook(String name,
                    int yearOfPublication,
                    long genreId,
                    long authorId);

    void findById(Long id);

    void deleteById(Long id);
}
