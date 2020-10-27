package com.example.LibraryAppDemo.controller;

import com.example.LibraryAppDemo.entity.Publisher;
import com.example.LibraryAppDemo.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService){
        this.publisherService = publisherService;
    }

    @GetMapping("/publishers")
    String getAllPublishers(Model model){
        List<Publisher> listPublishers = publisherService.getAll();
        model.addAttribute("listPublishers", listPublishers);
        return "index";

    }

    @RequestMapping("/newPublisher")
    String newPublisher(Model model){
        Publisher publisher = new Publisher();
        model.addAttribute("publisher", publisher);
        return "newPublisher";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    String savePublisher(@ModelAttribute("publisher") Publisher publisher){
        publisherService.save(publisher);
        return "redirect:/publishers";
    }

    @DeleteMapping("/deletePublisherById")
    void deletePublisherById(Long id){
        publisherService.delete(id);
    }

    @PutMapping("/updatePublisher")
    Publisher updatePublisher(@RequestBody Publisher updatePublisher){
        return publisherService.save(updatePublisher);
    }
}
