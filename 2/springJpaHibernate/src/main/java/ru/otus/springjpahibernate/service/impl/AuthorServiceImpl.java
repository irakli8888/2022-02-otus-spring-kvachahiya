package ru.otus.springjpahibernate.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.springjpahibernate.model.Author;
import ru.otus.springjpahibernate.repository.impl.AuthorRepositoryImpl;
import ru.otus.springjpahibernate.service.AuthorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepositoryImpl authorRepository;

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
        return authorRepository.add(author);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
