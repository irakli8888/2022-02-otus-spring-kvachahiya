package ru.otus.springdatamongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import ru.otus.springdatamongodb.model.Genre;

@Component
public interface GenreRepository extends MongoRepository<Genre, Long> {
}
