package ru.otus.springmvcview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.otus.springmvcview.model.Genre;

@Component
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
