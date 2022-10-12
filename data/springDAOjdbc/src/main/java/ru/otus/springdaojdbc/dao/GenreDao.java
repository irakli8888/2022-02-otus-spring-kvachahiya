package ru.otus.springdaojdbc.dao;

import ru.otus.springdaojdbc.model.Genre;

public interface GenreDao<T extends Number, K> extends DomainCrud<Long, Genre>{
}
