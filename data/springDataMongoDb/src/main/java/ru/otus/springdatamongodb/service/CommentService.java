package ru.otus.springdatamongodb.service;


import ru.otus.springdatamongodb.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    List<Comment> findByBookId(Long bookId);
}
