package ru.otus.springjpahibernate.repository;

import ru.otus.springjpahibernate.model.Comment;

public interface CommentRepository<T extends Number, K> extends DomainCrudRepository<Long, Comment> {

}
