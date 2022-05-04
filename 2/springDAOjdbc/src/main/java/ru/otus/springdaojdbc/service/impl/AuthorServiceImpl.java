package ru.otus.springdaojdbc.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.otus.springdaojdbc.dao.impl.AuthorDaoJdbc;
import ru.otus.springdaojdbc.model.Author;
import ru.otus.springdaojdbc.service.AuthorService;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDaoJdbc authorDao;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void showAll() {
        List<Author> authorList = authorDao.findAll();

        if (authorList.size() != 0) {
            authorDao
                    .findAll()
                    .forEach(a -> System.out.println(MessageFormat.format("author:{0}", a.toString())));
        } else {
            logger.debug("No author");
        }
    }

    @Override
    public void addAuthor(String name, String lastname) {
        Author author = new Author();
        author.setName(name);
        author.setLastName(lastname);
        author = authorDao.add(author);
        System.out.println("author created "+ author);
    }

    @Override
    public void deleteById(Long id){
        authorDao.deleteById(id);
    }
}
