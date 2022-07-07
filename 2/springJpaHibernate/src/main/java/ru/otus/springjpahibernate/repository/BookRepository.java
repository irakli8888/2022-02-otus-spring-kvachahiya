package ru.otus.springjpahibernate.repository;

import ru.otus.springjpahibernate.model.Book;

public interface BookRepository <T extends Number, K> extends DomainCrudRepository<Long, Book>{

}
