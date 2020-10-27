package com.example.LibraryAppDemo.controller;

import com.example.LibraryAppDemo.entity.Author;
import com.example.LibraryAppDemo.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/newAuthor")
    Author newAuthor(Author author){
        return authorService.save(author);
    }

    @DeleteMapping("/deleteAuthorById")
    void deleteAuthorById(Long id){
        authorService.delete(id);
    }

    @PutMapping("/updateAuthor")
    Author updateAuthor(@RequestBody Author updateAuthor){
        return authorService.save(updateAuthor);
    }

    @GetMapping("/authors")
    List<Author> getAllAuthors(){
        return authorService.getAll();
    }

}
