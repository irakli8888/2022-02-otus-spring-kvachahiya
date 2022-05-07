package ru.otus.springjpahibernate.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.springjpahibernate.model.Book;
import ru.otus.springjpahibernate.repository.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository<Long, Book> {

    private final EntityManager entityManager;

    @Override
    public Book add(Book book) {
        if (Objects.isNull(book.getId())) {
            entityManager.persist(book);
            return book;
        } else {
            return entityManager.merge(book);
        }
    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(Book book) {
        entityManager.remove(book);
    }

    @Override
    public List<Book> findAll() {
        return entityManager
                .createQuery("select b from Book b", Book.class).getResultList();
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
        TypedQuery<Book> query = entityManager.createQuery(
                "select b from Book b where b.id = :id"
                , Book.class);
        query.setParameter("id", id);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

}
