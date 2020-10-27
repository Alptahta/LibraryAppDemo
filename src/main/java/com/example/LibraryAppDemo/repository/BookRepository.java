package com.example.LibraryAppDemo.repository;

import com.example.LibraryAppDemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByName(String name);

    Book findByIsbn(String isbn);

    Book findByBookSerialName(String bookSerialName);

    List<Book> findByAuthor(String author);

    List<Book> findByPublisher(String publisher);

}
