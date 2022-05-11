package ru.otus.springjpahibernate.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.otus.springjpahibernate.model.Book;
import ru.otus.springjpahibernate.repository.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
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
    public void delete(Book book) {
        entityManager.remove(book);
    }

    @Override
    public List<Book> findAll() {
        return entityManager
                .createQuery("select b from Book b " +
                        "left join fetch b.commentList", Book.class).getResultList();
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(findById(id).get());
    }

    @Override
    public Optional findById(Long id) {
        Book book = entityManager.find(Book.class, id);
        try {
            return Optional.of(book);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

}
