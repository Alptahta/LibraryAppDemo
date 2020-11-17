package com.example.LibraryAppDemo.controller;

import com.example.LibraryAppDemo.entity.Publisher;
import com.example.LibraryAppDemo.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService){
        this.publisherService = publisherService;
    }

    @GetMapping
    String getAllPublishers(Model model){
        List<Publisher> listPublishers = publisherService.findAll();
        model.addAttribute("listPublishers", listPublishers);
        return "publishers";
    }

    @GetMapping("/add-publisher")
    public String showAddPublisherForm(Publisher publisher) {
        return "add-publisher";
    }

    @PostMapping("/addpublisher")
    public String addPublisher(@Valid Publisher publisher, BindingResult result, Model model) {
        publisherService.save(publisher);
        model.addAttribute("publishers", publisherService.findAll());
        return "redirect:/publishers";
    }

    @GetMapping("/edit/{id}")
    public String showPublisherUpdateForm(@PathVariable("id") long id, Model model) {
        Publisher publisher = publisherService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid publisher Id:" + id));;
        model.addAttribute("publisher", publisher);
        return "update-publisher";
    }

    @PostMapping("/update/{id}")
    public String updatePublisher(@PathVariable("id") long id, @Valid Publisher publisher, BindingResult result, Model model) {
        publisherService.save(publisher);
        model.addAttribute("publishers", publisherService.findAll());
        return "redirect:/publishers";
    }

    @RequestMapping("/delete/{id}")
    String deletePublisher(@PathVariable(name = "id") long id){
        publisherService.delete(id);
        return "redirect:/publishers";
    }


}
