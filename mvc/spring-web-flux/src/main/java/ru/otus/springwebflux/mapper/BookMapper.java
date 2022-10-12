package ru.otus.springwebflux.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.otus.springwebflux.model.Book;
import ru.otus.springwebflux.model.dto.BookDto;


@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "author.name", target = "authorName")
    @Mapping(source = "genre.name", target = "genreName")
    BookDto toDto(Book book);
}
