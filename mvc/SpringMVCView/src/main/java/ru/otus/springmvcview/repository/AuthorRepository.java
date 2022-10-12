package ru.otus.springmvcview.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.otus.springmvcview.model.Author;

@Component
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
