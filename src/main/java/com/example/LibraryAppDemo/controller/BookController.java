package com.example.LibraryAppDemo.controller;

import com.example.LibraryAppDemo.entity.Author;
import com.example.LibraryAppDemo.entity.Book;
import com.example.LibraryAppDemo.entity.Publisher;
import com.example.LibraryAppDemo.service.AuthorService;
import com.example.LibraryAppDemo.service.BookService;
import com.example.LibraryAppDemo.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    private final PublisherService publisherService;

    private final AuthorService authorService;

    public BookController(BookService bookService, PublisherService publisherService, AuthorService authorService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }



    @GetMapping
    String getAllBooks(Model model){
        List<Book> listBooks = bookService.findAll();
        model.addAttribute("listBooks", listBooks);
        return "books";
    }

    @GetMapping("/add-book")
    public String showAddBookForm(Book book, Model model){
        List<Publisher> listPublishers = publisherService.findAll();
        List<Author> listAuthors = authorService.findAll();
        model.addAttribute("listPublishers", listPublishers);
        model.addAttribute("listAuthors", listAuthors);
        return "add-book";
    }

    @PostMapping("/addbook")
    public String addBook(@Valid Book book, BindingResult result, Model model) {
        bookService.save(book);
        model.addAttribute("books", bookService.findAll());
        return "redirect:/books";
    }
    @GetMapping("/edit/{id}")
    public String showBookUpdateForm(@PathVariable("id") long id, Model model) {
        Book book = bookService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));;
        model.addAttribute("book", book);
        return "update-book";
    }
    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") long id, @Valid Book book, BindingResult result, Model model) {
        bookService.save(book);
        model.addAttribute("books", bookService.findAll());
        return "redirect:/books";
    }


    @RequestMapping("/delete/{id}")
    String deleteBook(@PathVariable(name = "id") long id){
        bookService.delete(id);
        return "redirect:/books";
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
    List<Book> getBookBySerialName(@RequestParam(value = "serial_name")String serialName){
        return bookService.getByBookSerialName(serialName);
    }

    @GetMapping("/getBookByAuthor")
    List<Book> getBookByAuthor(@RequestParam(value = "author")String author){
        return bookService.getByAuthor(author);
    }



}
