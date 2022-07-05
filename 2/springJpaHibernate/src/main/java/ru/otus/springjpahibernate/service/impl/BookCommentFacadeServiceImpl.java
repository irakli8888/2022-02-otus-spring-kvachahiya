package ru.otus.springjpahibernate.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellOption;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.springjpahibernate.model.Comment;
import ru.otus.springjpahibernate.service.BookCommentFacadeService;
import ru.otus.springjpahibernate.service.BookService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookCommentFacadeServiceImpl implements BookCommentFacadeService {

    private final BookService bookService;

    @Override
    @Transactional
    public List<Comment> showBooksCommentsByBook(@ShellOption(value = {"id", "i"}) Long id){
        return bookService
                .findById(id)
                .getCommentList();
    }
}
