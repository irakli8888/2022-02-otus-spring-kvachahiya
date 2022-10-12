package ru.otus.springwebflux.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;
import ru.otus.springwebflux.model.Genre;


@Component
public interface GenreRepository extends ReactiveMongoRepository<Genre, Long> {
}
