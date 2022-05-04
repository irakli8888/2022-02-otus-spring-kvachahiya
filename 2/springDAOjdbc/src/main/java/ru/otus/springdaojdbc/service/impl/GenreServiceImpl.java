package ru.otus.springdaojdbc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.springdaojdbc.dao.impl.GenreDaoJdbc;
import ru.otus.springdaojdbc.model.Genre;
import ru.otus.springdaojdbc.service.GenreService;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {


    private final GenreDaoJdbc genreDaoJdbc;

    @Override
    public Genre add(String name){
        Genre genre = new Genre();
        genre.setName(name);
        genre = genreDaoJdbc.add(genre);
        System.out.println(genre.toString());
        return genre;
    }

    @Override
    public void findAll(){
        List<Genre> genreList = genreDaoJdbc.findAll();

        if (genreList.size() != 0) {
            genreList
                    .forEach(a -> System.out.println(MessageFormat.format("genre:{0}", a.toString())));
        } else {
            System.out.println("No genre");
        }
    }

    @Override
    public void deleteById(Long id){
        genreDaoJdbc.deleteById(id);
    }
}
