package ru.otus.springmvcview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.otus.springmvcview.model.Book;

@Component
public interface BookRepository extends JpaRepository<Book, Long> {
}
