package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.example.domain.Messages;
import org.example.repos.MessagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("message")
public class MainController {

    private final MessagesRepo messagesRepo;

    @Autowired
    public MainController(MessagesRepo messagesRepo) {
        this.messagesRepo = messagesRepo;
    }

    @GetMapping
    public List<Messages> Example() {
        return messagesRepo.findAll();
    }

    @PostMapping
    public Messages create(@RequestBody Messages message) {
        return messagesRepo.save(message);
    }


}
