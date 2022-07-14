package ru.otus.springmvcview.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.springmvcview.model.request.BookRequest;
import ru.otus.springmvcview.service.AuthorService;
import ru.otus.springmvcview.service.BookService;
import ru.otus.springmvcview.service.GenreService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    @PostMapping("/create")
    public String addBook(Model model,
                          @ModelAttribute("request") BookRequest request){
        bookService.createBook(request.getName(),
                request.getYearOfPublication(),
                request.getGenreId(),
                request.getAuthorId());
        return "redirect:/book";
    }

    @GetMapping("/create")
    public String getAddBookPage(Model model){
        model.addAttribute("genres", genreService.findAll());
        model.addAttribute("authors", authorService.findAll());
        return "createBook";
    }


    @GetMapping("")
    public String findAllBook(Model model){
        model.addAttribute("genres", genreService.findAll());
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("books", bookService.findAll());
        return "book";
    }

//    putmapping не доступен при отправке формы
    @PostMapping("/edit")
    public String editBook(BookRequest bookRequest, Model model){
        bookService.edit(bookRequest);
        return "redirect:/book";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") Long id, Model model){
        bookService.deleteById(id);
        return "redirect:/book";
    }
}
