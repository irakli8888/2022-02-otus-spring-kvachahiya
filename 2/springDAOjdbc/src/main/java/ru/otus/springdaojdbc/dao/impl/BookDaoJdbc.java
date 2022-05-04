package ru.otus.springdaojdbc.dao.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.springdaojdbc.dao.BookDao;
import ru.otus.springdaojdbc.model.Author;
import ru.otus.springdaojdbc.model.Book;
import ru.otus.springdaojdbc.model.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookDaoJdbc implements BookDao<Long, Book> {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Book add(Book book) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();

        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("name", book.getName())
                .addValue("year_of_publication", book.getYearOfPublication())
                .addValue("genre_id", book.getGenre().getId())
                .addValue("author_id", book.getAuthor().getId());
        String insertSql =  "insert into book (name, year_of_publication, genre_id, author_id)\n" +
                "values (:name, :year_of_publication, :genre_id, :author_id)";

        int status = jdbcTemplate.update(insertSql, parameters, holder, new String[] { "id" });
        book.setId(holder.getKey().longValue());
        if (status != 0) {
            logger.debug("The book has been created");
        } else {
            logger.debug("The book has not been created");
        }
        return book;
    }

    @Override
    public void update(Book book) {
        String updateSql =
                "update book\n" +
                        "set  name = :name, year_of_publication = :year_of_publication,\n" +
                        "genre_id = :genre_id , author_id = :author_id";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", book.getId())
                .addValue("name", book.getName())
                .addValue("year_of_publication", book.getYearOfPublication())
                .addValue("genre_id", book.getYearOfPublication())
                .addValue("author_id", book.getYearOfPublication());
        int status = jdbcTemplate.update(updateSql, parameters);
        if (status != 0) {
            logger.debug("The book with id = " + book.getId() + " has been updated");
        } else {
            logger.debug("The book has not been updated");
        }
    }

    @Override
    public void delete(Book book) {
        deleteById(book.getId());
    }

    @Override
    public List findAll() {
        String selectBookSql = "select book.id," +
                "book.name," +
                "book.year_of_publication," +
                "genre.id as genre_id," +
                "author.id as author_id," +
                "genre.name as genre_name," +
                "author.name as author_name, " +
                "author.last_name as author_last_name " +
                "from book book " +
                "left join author author on author.id = book.author_id " +
                "left join genre genre on genre.id = book.genre_id";
        return jdbcTemplate.query(selectBookSql, new BookExtractor());
    }

    @Override
    public void deleteById(Long id) {
        var namedParameters = new MapSqlParameterSource("id", id);
        String deleteSql = "delete from book where id = :id";
        int status = jdbcTemplate.update(deleteSql, namedParameters);
        if (status != 0) {
            logger.debug("Book with id = " + id + " removed from storage");
        } else {
            logger.debug("Book not found in storage");
        }
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Book findById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        String findByIdSql = "select book.id," +
                "book.name," +
                "book.year_of_publication," +
                "genre.id as genre_id," +
                "author.id as author_id," +
                "genre.name as genre_name," +
                "author.name as author_name," +
                "author.last_name as author_last_name " +
                "from book book " +
                "left join author author on author.id = book.author_id " +
                "left join genre genre on genre.id = book.genre_id where book.id = :id";
        return jdbcTemplate.query(findByIdSql, namedParameters, new BookExtractor()).get(0);
    }

    private static class BookExtractor implements ResultSetExtractor<List<Book>> {
        @Override
        public List<Book> extractData(ResultSet rs) throws SQLException, DataAccessException {
            HashMap<Long, Book> books = new HashMap<Long, Book>();
            while (rs.next()){
                Book book = new Book();
                book.setId(rs.getLong("id"));
                book.setName(rs.getString("name"));
                if(rs.getString("author_id") != null){
                    book.setAuthor(new Author(rs.getLong("author_id"), rs.getString("author_name"), rs.getString("author_last_name")));
                }
                if(rs.getString("genre_id") != null){
                    book.setGenre(new Genre(rs.getLong("genre_id"),rs.getString("genre_name")));
                }
                books.put(book.getId(), book);
            }
            return new ArrayList<>(books.values());
        }
    }

}

