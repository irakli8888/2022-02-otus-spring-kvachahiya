package ru.otus.springdatajdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "year_of_publication", nullable = false)
    private int yearOfPublication;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private Genre genre;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    //fetch = FetchType.LAZY, - по умолчанию
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(orphanRemoval = true,
            fetch = FetchType.LAZY,
            mappedBy = "book")
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
