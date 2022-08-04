package ru.otus.springmvcwajax.service;

import ru.otus.springmvcwajax.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    List<Comment> findByBookId(Long bookId);
}
