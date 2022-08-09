package ru.otus.springmvcwajax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.otus.springmvcwajax.model.Genre;

@Component
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
