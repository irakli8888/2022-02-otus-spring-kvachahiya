package ru.otus.springdatamongodb.migrations;


import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otus.springdatamongodb.model.Author;
import ru.otus.springdatamongodb.repository.AuthorRepository;


@ChangeUnit(id = "init", order = "001")
public class DatabaseChangelog {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Execution()
    public void migrateAuthor(AuthorRepository authorRepository) {
        authorRepository.deleteAll();
        Author author = new Author();
        author.setId(1L);
        author.setName("author");
        authorRepository.save(author);
        authorRepository.findAll().forEach(a -> logger.info(String.format("Author added: %s", a.toString())));
    }

    @RollbackExecution
    public void rollback(AuthorRepository authorRepository) {
       authorRepository.deleteById(1L);
    }

}
