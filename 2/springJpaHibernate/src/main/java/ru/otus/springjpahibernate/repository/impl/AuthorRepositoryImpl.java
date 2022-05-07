package ru.otus.springjpahibernate.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.springjpahibernate.model.Author;
import ru.otus.springjpahibernate.repository.AuthorRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository<Long, Author> {

    private final EntityManager entityManager;

    @Override
    public Author add(Author author) {
        if (Objects.isNull(author.getId())) {
            entityManager.persist(author);
            return author;
        } else {
         return entityManager.merge(author);
        }
    }

    @Override
    public void update(Author author) {

    }

    @Override
    public void delete(Author author) {
        entityManager.remove(author);
    }

    @Override
    public List<Author> findAll() {
        return entityManager
                .createQuery("select a from Author a", Author.class).getResultList();
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(findById(id).get());
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Optional findById(Long id) {
        TypedQuery<Author> query = entityManager.createQuery(
                "select a from Author a where a.id = :id"
                , Author.class);
        query.setParameter("id", id);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
