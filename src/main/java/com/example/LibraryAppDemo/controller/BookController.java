package com.example.LibraryAppDemo.controller;

import com.example.LibraryAppDemo.entity.Book;
import com.example.LibraryAppDemo.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    List<Book> getAllBooks(){
        return bookService.getAll();
    }

    @GetMapping("/getBookById")
    Book getBookById(@PathVariable Long  id){
        return bookService.getById(id);
    }

    @GetMapping("/getBooksByISBN")
    Book getBookByISBN(@RequestParam(value = "isbn") String isbn){
        return bookService.getByISBN(isbn);
    }

    @GetMapping("/getBookByName")
    Book getBookByName(@RequestParam(value = "name") String name){
        return bookService.getByName(name);
    }

    @GetMapping("/getBookBySerialName")
    Book getBookBySerialName(@RequestParam(value = "serial_name")String serialName){
        return bookService.getByBookSerialName(serialName);
    }

    @GetMapping("/getBookByAuthor")
    List<Book> getBookByAuthor(@RequestParam(value = "author")String author){
        return bookService.getByAuthor(author);
    }

    @PostMapping("/newBook")
    Book newBook(@RequestBody Book newBook){
        return bookService.save(newBook);
    }

    @PutMapping("/updateBook")
    Book updateBook(@RequestBody Book updateBook){
        return bookService.save(updateBook);
    }

    @DeleteMapping("/deleteBookById")
    void deleteBookById(@PathVariable Long id){
        bookService.delete(id);
    }
}
