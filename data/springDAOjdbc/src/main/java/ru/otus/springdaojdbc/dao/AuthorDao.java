package ru.otus.springdaojdbc.dao;

import org.springframework.stereotype.Repository;
import ru.otus.springdaojdbc.model.Author;


@Repository
public interface AuthorDao<T extends Number, K> extends DomainCrud<Long, Author> {
}
