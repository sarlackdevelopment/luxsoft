package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.example.domain.Messages;
import org.example.repos.MessagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class MessagesController {

    private final MessagesRepo messagesRepo;

    @Autowired
    public MessagesController(MessagesRepo messagesRepo) {
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
