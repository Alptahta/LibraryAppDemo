package com.example.LibraryAppDemo.service;

import com.example.LibraryAppDemo.entity.Book;
import com.example.LibraryAppDemo.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public Optional<Book> findById(Long id){
        return bookRepository.findById(id);
    }

    public List<Book> getByBookSerialName(String serialName){
        return bookRepository.findBySerialName(serialName);
    }

    public List<Book> getByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }


}
