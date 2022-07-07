package ru.otus.springjpahibernate.repository;

import ru.otus.springjpahibernate.model.Genre;

public interface GenreRepository<T extends Number, K> extends DomainCrudRepository<Long, Genre> {
}
