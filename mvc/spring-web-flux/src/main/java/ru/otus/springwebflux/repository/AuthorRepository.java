package ru.otus.springwebflux.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;
import ru.otus.springwebflux.model.Author;

@Component
public interface AuthorRepository extends ReactiveMongoRepository<Author, Long> {
}
