package ru.otus.springdaojdbc.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.springdaojdbc.dao.GenreDao;
import ru.otus.springdaojdbc.model.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GenreDaoJdbc implements GenreDao<Long, Genre> {

    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    @Override
    public Genre add(Genre genre) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource().addValue("name", genre.getName());
        String insertSql = "insert into genre (name) values(:name)";
        namedJdbcTemplate.update(insertSql, parameters, holder, new String[] { "id" });
        genre.setId(holder.getKey().longValue());
        return genre;
    }

    @Override
    public void update(Genre domain) {

    }

    @Override
    public void delete(Genre genre) {
        deleteById(genre.getId());
    }

    @Override
    public List<Genre> findAll() {
        String findAllSql = "select id, name from genre";
        return namedJdbcTemplate.query(findAllSql, new GenreRowMapper());
    }

    @Override
    public void deleteById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        String deleteSql = "delete from genre where id= :id";
        int status = namedJdbcTemplate.update(deleteSql, namedParameters);
        if (status != 0) {
            System.out.println("Genre with id = " + id + " removed from storage");
        } else {
            System.out.println("Genre not found in storage");
        }
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Genre findById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        String findByIdSql = "select * from genre where id = :id";
        return namedJdbcTemplate.queryForObject(findByIdSql, namedParameters, new GenreRowMapper());
    }

    private static class GenreRowMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Genre(rs.getLong("id"),
                    rs.getString("name"));
        }
    }
}
