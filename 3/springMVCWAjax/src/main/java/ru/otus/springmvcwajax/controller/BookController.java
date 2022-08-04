package ru.otus.springmvcwajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @GetMapping("")
    public String findAllBook(Model model){
        return "book";
    }
}
