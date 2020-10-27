package com.example.LibraryAppDemo.service;

import com.example.LibraryAppDemo.entity.Book;
import com.example.LibraryAppDemo.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }

    public void delete(Long id){
        bookRepository.deleteById(id);
    }

    public Book getByISBN(String isbn){
        return bookRepository.findByIsbn(isbn);
    }

    public Book getByName(String name){
        return bookRepository.findByName(name);
    }

    public Book getById(Long id){
        return bookRepository.getOne(id);
    }

    public Book getByBookSerialName(String name){
        return bookRepository.findByBookSerialName(name);
    }

    public List<Book> getByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }


}
