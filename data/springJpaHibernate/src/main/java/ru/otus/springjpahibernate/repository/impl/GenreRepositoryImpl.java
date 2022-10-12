package ru.otus.springjpahibernate.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.otus.springjpahibernate.model.Genre;
import ru.otus.springjpahibernate.repository.GenreRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GenreRepositoryImpl implements GenreRepository<Long, Genre> {

    private final EntityManager entityManager;

    @Override
    public Genre add(Genre genre) {
        if (Objects.isNull(genre.getId())) {
            entityManager.persist(genre);
            return genre;
        } else {
            return entityManager.merge(genre);
        }
    }

    @Override
    public void delete(Genre genre) {
        entityManager.remove(genre);
    }

    @Override
    public List<Genre> findAll() {
        return entityManager
                .createQuery("select g from Genre g", Genre.class).getResultList();
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(findById(id).get());
    }

    @Override
    public Optional findById(Long id) {
        Genre genre = entityManager.find(Genre.class, id);
        try {
            return Optional.of(genre);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
