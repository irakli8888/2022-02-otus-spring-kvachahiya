package ru.otus.springmvcview.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.springmvcview.model.Author;
import ru.otus.springmvcview.repository.AuthorRepository;
import ru.otus.springmvcview.service.AuthorService;

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
