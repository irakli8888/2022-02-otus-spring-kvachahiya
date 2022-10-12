package ru.otus.springdatajdbc.service;

import ru.otus.springdatajdbc.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    List<Comment> findByBookId(Long bookId);
}
