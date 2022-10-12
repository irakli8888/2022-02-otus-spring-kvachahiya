package ru.otus.springdatajdbc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.springdatajdbc.model.Comment;
import ru.otus.springdatajdbc.repository.CommentRepository;
import ru.otus.springdatajdbc.service.CommentService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> findByBookId(Long bookId){
        return commentRepository.findCommentByBook_Id(bookId);
    }
}
