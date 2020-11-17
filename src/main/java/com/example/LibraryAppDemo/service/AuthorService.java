package com.example.LibraryAppDemo.service;

import com.example.LibraryAppDemo.entity.Author;
import com.example.LibraryAppDemo.entity.Publisher;
import com.example.LibraryAppDemo.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author save(Author author){
        return authorRepository.save(author);
    }

    public void delete(Long id){
        authorRepository.deleteById(id);
    }

    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    public Optional<Author> findById(Long id){
        return authorRepository.findById(id);
    }
}
