package ru.otus.springwebflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import ru.otus.springwebflux.model.Book;

@Repository
public interface BookRepository extends ReactiveMongoRepository<Book, Long> {
}
