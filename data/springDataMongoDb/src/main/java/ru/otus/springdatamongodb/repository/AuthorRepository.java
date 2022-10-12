package ru.otus.springdatamongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import ru.otus.springdatamongodb.model.Author;

@Component
public interface AuthorRepository extends MongoRepository<Author, Long> {
}
