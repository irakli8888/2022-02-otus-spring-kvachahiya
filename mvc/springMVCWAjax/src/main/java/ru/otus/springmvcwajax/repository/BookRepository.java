package ru.otus.springmvcwajax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.otus.springmvcwajax.model.Book;

@Component
public interface BookRepository extends JpaRepository<Book, Long> {
}
