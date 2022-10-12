package ru.otus.springdatamongodb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.springdatamongodb.model.Comment;
import ru.otus.springdatamongodb.repository.CommentRepository;
import ru.otus.springdatamongodb.service.CommentService;

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
