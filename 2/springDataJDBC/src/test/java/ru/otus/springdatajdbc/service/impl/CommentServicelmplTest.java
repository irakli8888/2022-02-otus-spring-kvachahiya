package ru.otus.springdatajdbc.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import ru.otus.springdatajdbc.service.CommentService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@DataJpaTest
@Import({CommentServiceImpl.class})
class CommentServicelmplTest {

    @Autowired
    CommentService commentService;

    @Test
    void findByBookId() {
        assertNotNull(commentService.findByBookId(10l), "books not found");
    }

    @AfterEach
    void tearDown() {
    }
}