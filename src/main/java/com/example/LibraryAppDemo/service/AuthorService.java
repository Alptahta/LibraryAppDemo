package com.example.LibraryAppDemo.service;

import com.example.LibraryAppDemo.entity.Author;
import com.example.LibraryAppDemo.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<Author> getAll(){
        return authorRepository.findAll();
    }
}
