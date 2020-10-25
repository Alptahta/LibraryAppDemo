package com.example.LibraryAppDemo.service;

import com.example.LibraryAppDemo.entity.Publisher;
import com.example.LibraryAppDemo.repository.PublisherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository){
        this.publisherRepository = publisherRepository;
    }

    public Publisher save(Publisher publisher){
        return publisherRepository.save(publisher);
    }

    public void delete(Long id){
        publisherRepository.deleteById(id);
    }
}
