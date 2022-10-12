package ru.otus.springwebflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import ru.otus.springwebflux.model.Comment;



@Repository
public interface CommentRepository extends ReactiveMongoRepository<Comment, Long> {
    Flux<Comment> findCommentByBook_Id(Long bookId);
}
