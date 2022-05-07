package ru.otus.springjpahibernate.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.springjpahibernate.model.Comment;
import ru.otus.springjpahibernate.repository.CommentRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository<Long, Comment> {

    private final EntityManager entityManager;

    @Override
    public Comment add(Comment comment) {
        if (Objects.isNull(comment.getId())) {
            entityManager.persist(comment);
            return comment;
        } else {
            return entityManager.merge(comment);
        }
    }

    @Override
    public void update(Comment comment) {

    }

    @Override
    public void delete(Comment comment) {
        entityManager.remove(comment);
    }

    @Override
    public List<Comment> findAll() {
        return entityManager
                .createQuery("select c from Comment c", Comment.class).getResultList();
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
        TypedQuery<Comment> query = entityManager.createQuery(
                "select c from Comment c where c.id = :id"
                , Comment.class);
        query.setParameter("id", id);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
