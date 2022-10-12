package ru.otus.springjpahibernate.repository.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.springjpahibernate.model.Comment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@DataJpaTest
@Import(CommentRepositoryImpl.class)
class CommentRepositoryImplTest {

    @Autowired
    CommentRepositoryImpl commentRepository;

    @Test
    void add() {
        Comment comment = new Comment();
        comment.setText("ss");
        Comment actualComment = commentRepository.add(comment);
        assertNotNull(actualComment.getId());
    }

    @Test
    void findAll() {
        assertEquals(1, commentRepository.findAll().size());

    }

    @Test
    void deleteById() {
        commentRepository.deleteById(1l);
        assertEquals(0, commentRepository.findAll().size());
    }

    @Test
    void findById() {
        Comment comment = (Comment) commentRepository.findById(1l).get();
        assertNotNull(comment);
    }
}