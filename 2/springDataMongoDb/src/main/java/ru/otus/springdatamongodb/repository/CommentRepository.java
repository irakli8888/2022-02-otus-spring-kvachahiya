package ru.otus.springdatamongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.otus.springdatamongodb.model.Comment;

import java.util.List;


@Repository
public interface CommentRepository extends MongoRepository<Comment, Long> {
    List<Comment> findCommentByBook_Id(Long bookId);
}
