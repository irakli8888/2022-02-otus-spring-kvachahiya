package ru.otus.springdatamongodb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(value = "book")
public class Book {

    @Id
    private Long id;

    private String name;

    private int yearOfPublication;
    @DBRef
    private Genre genre;
    @DBRef
    private Author author;
    @DBRef
    private List<Comment> commentList;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", genre=" + genre +
                ", author=" + author +
                ", commentList=" + commentList +
                '}';
    }
}
