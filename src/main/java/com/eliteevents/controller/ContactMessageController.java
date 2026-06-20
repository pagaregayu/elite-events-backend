package com.eliteevents.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eliteevents.entity.ContactMessage;
import com.eliteevents.service.ContactMessageService;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin("*")
public class ContactMessageController {

    @Autowired
    private ContactMessageService service;

    @PostMapping
    public ContactMessage saveMessage(
            @RequestBody ContactMessage message) {

        return service.saveMessage(message);

    }

    @GetMapping
    public List<ContactMessage> getMessages() {

        return service.getAllMessages();

    }

    @DeleteMapping("/{id}")
    public void deleteMessage(
            @PathVariable Long id) {

        service.deleteMessage(id);

    }
}