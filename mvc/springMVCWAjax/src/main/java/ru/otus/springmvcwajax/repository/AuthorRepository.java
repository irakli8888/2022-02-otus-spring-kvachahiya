package ru.otus.springmvcwajax.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.otus.springmvcwajax.model.Author;

@Component
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
