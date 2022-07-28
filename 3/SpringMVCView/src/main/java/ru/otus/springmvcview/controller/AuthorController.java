package ru.otus.springmvcview.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.otus.springmvcview.service.AuthorService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("")
    public String getAuthorsPage(Model model){
        model.addAttribute("authors", authorService.findAll());
        return "author";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") Long id, Model model){
        authorService.deleteById(id);
        return "redirect:/author";
    }
}
