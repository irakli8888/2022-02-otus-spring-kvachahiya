package ru.otus.springmvcview.service;

import ru.otus.springmvcview.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    List<Comment> findByBookId(Long bookId);
}
