package ru.otus.springjpahibernate.service;

import ru.otus.springjpahibernate.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();
}
