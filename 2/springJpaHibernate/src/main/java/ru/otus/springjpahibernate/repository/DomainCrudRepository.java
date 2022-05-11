package ru.otus.springjpahibernate.repository;

import java.util.List;
import java.util.Optional;

public interface DomainCrudRepository<K, T> {
    T add(T domain);

    void delete(T domain);

    List<T> findAll();

    void deleteById(K id);

    Optional findById(K id);
}