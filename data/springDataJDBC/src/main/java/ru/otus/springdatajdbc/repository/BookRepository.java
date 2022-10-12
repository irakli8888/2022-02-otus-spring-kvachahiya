package ru.otus.springdatajdbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.otus.springdatajdbc.model.Book;

@Component
public interface BookRepository extends JpaRepository<Book, Long> {
}
