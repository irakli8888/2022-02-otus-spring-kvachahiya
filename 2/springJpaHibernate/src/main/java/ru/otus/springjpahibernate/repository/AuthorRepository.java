package ru.otus.springjpahibernate.repository;

import ru.otus.springjpahibernate.model.Author;

public interface AuthorRepository<T extends Number, K> extends DomainCrudRepository<Long, Author>{
}
