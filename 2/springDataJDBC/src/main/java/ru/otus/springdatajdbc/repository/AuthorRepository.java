package ru.otus.springdatajdbc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.otus.springdatajdbc.model.Author;

@Component
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
