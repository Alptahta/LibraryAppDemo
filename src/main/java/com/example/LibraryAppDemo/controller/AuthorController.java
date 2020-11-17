package com.example.LibraryAppDemo.controller;

import com.example.LibraryAppDemo.entity.Author;
import com.example.LibraryAppDemo.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping
    String getAllAuthors(Model model){
        List<Author> listAuthors = authorService.findAll();
        model.addAttribute("listAuthors", listAuthors);
        return "authors";
    }

    @GetMapping("/add-author")
    public String showAddAuthorForm(Author author) {
        return "add-author";
    }

    @PostMapping("/addauthor")
    public String addAuthor(@Valid Author author, BindingResult result, Model model) {
        authorService.save(author);
        model.addAttribute("authors", authorService.findAll());
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String showAuthorUpdateForm(@PathVariable("id") long id, Model model) {
        Author author = authorService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));;
        model.addAttribute("author", author);
        return "update-author";
    }

    @PostMapping("/update/{id}")
    public String updateAuthor(@PathVariable("id") long id, @Valid Author author, BindingResult result, Model model) {
        authorService.save(author);
        model.addAttribute("authors", authorService.findAll());
        return "redirect:/authors";
    }

    @RequestMapping("/delete/{id}")
    String deleteAuthor(@PathVariable(name = "id") long id){
        authorService.delete(id);
        return "redirect:/authors";
    }



}
