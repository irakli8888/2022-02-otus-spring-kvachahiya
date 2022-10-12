package ru.otus.springdatajdbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.otus.springdatajdbc.model.Genre;

@Component
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
