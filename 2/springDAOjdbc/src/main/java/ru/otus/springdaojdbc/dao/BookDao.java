package ru.otus.springdaojdbc.dao;

import ru.otus.springdaojdbc.model.Book;


public interface BookDao<T extends Number, K> extends DomainCrud<Long, Book>{

}


