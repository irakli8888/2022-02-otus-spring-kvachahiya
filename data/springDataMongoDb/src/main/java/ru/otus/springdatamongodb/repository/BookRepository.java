package ru.otus.springdatamongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import ru.otus.springdatamongodb.model.Book;

@Component
public interface BookRepository extends MongoRepository<Book, Long> {
}
