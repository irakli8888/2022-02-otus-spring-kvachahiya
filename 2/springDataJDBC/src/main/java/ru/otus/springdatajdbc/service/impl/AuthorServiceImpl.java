package ru.otus.springdatajdbc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.springdatajdbc.model.Author;
import ru.otus.springdatajdbc.repository.AuthorRepository;
import ru.otus.springdatajdbc.service.AuthorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    @Transactional
    public Author addAuthor(String name, String lastname) {
        Author author = new Author();
        author.setName(name);
        author.setLastName(lastname);
        authorRepository.save(author);
        return author;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
