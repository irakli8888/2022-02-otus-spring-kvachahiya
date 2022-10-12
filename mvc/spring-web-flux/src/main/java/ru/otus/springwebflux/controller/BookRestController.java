package ru.otus.springwebflux.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.otus.springwebflux.mapper.BookMapper;
import ru.otus.springwebflux.model.dto.BookDto;
import ru.otus.springwebflux.repository.BookRepository;


@RestController
@RequiredArgsConstructor
public class BookRestController {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @GetMapping("/book")
    public Flux<BookDto> findAllBook(){
        return bookRepository
                .findAll()
                .map(book -> bookMapper.toDto(book));
    }

    @PostMapping("/book/delete/{id}")
    public void deleteBook(@PathVariable(value = "id") Long id){
        bookRepository.deleteById(id);
    }
}
