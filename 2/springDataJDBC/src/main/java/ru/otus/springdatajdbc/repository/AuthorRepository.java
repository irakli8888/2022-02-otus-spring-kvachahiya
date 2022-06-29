package ru.otus.springdatajdbc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.springdatajdbc.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
