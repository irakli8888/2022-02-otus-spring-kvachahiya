package ru.otus.springdaojdbc.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.springdaojdbc.dao.AuthorDao;
import ru.otus.springdaojdbc.model.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class AuthorDaoJdbc implements AuthorDao<Long, Author> {

    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    @Override
    public Author add(Author author) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("name", author.getName())
                .addValue("last_name", author.getLastName());
        String insertSql = "insert into author (name, last_name) values(:name, :last_name)";
        namedJdbcTemplate.update(insertSql, parameters, holder, new String[] {"id"});
        author.setId(holder.getKey().longValue());
        return author;
    }

    @Override
    public void update(Author domain) {

    }

    @Override
    public void delete(Author author) {
        deleteById(author.getId());
    }

    @Override
    public List<Author> findAll() {
        String findAllSql = "select id, name, last_name from author";
        return namedJdbcTemplate.query(findAllSql, new AuthorRowMapper());
    }

    @Override
    public void deleteById(Long id) {
        var namedParameters = new MapSqlParameterSource("id", id);
         String deleteSql = "delete from author where id= :id";
        int status = namedJdbcTemplate.update(deleteSql, namedParameters);
        if (status != 0) {
            System.out.println("Author with id = " + id + " removed from storage");
        } else {
            System.out.println("Author not found in storage");
        }
    }

    @Override
    public Author findById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        String findByIdSql = "select * from author where id = :id";
        return namedJdbcTemplate.queryForObject(findByIdSql, namedParameters, new AuthorRowMapper());
    }

    @Override
    public Long count() {
        return null;
    }

    private static class AuthorRowMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Author(rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("last_name"));
        }
    }
}
