package ru.otus.springdatajdbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.springdatajdbc.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
