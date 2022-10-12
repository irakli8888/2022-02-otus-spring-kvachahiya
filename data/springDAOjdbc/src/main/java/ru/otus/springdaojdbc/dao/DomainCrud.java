package ru.otus.springdaojdbc.dao;

import java.util.List;

public interface DomainCrud<K, T> {
    T add(T domain);

    void update(T domain);

    void delete(T domain);

    List<T> findAll();

    void deleteById(K id);

    K count();

    T findById(K id);
}
