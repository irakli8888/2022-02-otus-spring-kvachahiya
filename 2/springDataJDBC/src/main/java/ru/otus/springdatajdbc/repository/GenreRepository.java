package ru.otus.springdatajdbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.springdatajdbc.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
