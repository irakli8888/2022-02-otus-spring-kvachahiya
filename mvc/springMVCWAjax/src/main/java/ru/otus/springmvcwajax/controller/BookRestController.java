package ru.otus.springmvcwajax.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.springmvcwajax.model.dto.BookDto;
import ru.otus.springmvcwajax.service.BookService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
public class BookRestController {

    private final BookService bookService;

    @GetMapping("/book")
    public List<BookDto> findAllBook(){
        return bookService.findAll();
    }


    @PostMapping("/book/delete/{id}")
    public void deleteBook(@PathVariable(value = "id") Long id, Model model){
        bookService.deleteById(id);
    }
}
