package ru.otus.springjpahibernate.service;

import org.springframework.shell.standard.ShellOption;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.springjpahibernate.model.Comment;

import java.util.List;

public interface BookCommentFacadeService {
    List<Comment> showBooksCommentsByBook(@ShellOption(value = {"id", "i"}) Long id);
}
