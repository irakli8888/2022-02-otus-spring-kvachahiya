package ru.otus.springmvcview.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.otus.springmvcview.service.GenreService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/genre")
public class GenreController {

    private final GenreService genreService;

    @GetMapping("")
    public String getAuthorsPage(Model model){
        model.addAttribute("genres", genreService.findAll());
        return "genre";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") Long id, Model model){
        genreService.deleteById(id);
        return "redirect:/genre";
    }
}
