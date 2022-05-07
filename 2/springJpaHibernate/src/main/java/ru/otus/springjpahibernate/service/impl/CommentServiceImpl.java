package ru.otus.springjpahibernate.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.springjpahibernate.model.Comment;
import ru.otus.springjpahibernate.repository.impl.CommentRepositoryImpl;
import ru.otus.springjpahibernate.service.CommentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepositoryImpl commentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }
}
