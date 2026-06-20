package com.eliteevents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliteevents.entity.ContactMessage;
import com.eliteevents.entity.Notification;
import com.eliteevents.repository.ContactMessageRepository;
import com.eliteevents.repository.NotificationRepository;



@Service
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository repository;
    

    @Autowired
    private NotificationRepository notificationRepository;

    public ContactMessage saveMessage(
            ContactMessage message) {

        ContactMessage saved =
                repository.save(message);

        Notification notification =
                new Notification();

        notification.setTitle(
                "New Contact Message");

        notification.setMessage(
                "New inquiry from "
                        + message.getName()
                        + " for "
                        + message.getEventType());

        notificationRepository.save(
                notification);

        return saved;
    }

    public List<ContactMessage> getAllMessages() {

        return repository.findAll();

    }

    public void deleteMessage(Long id) {

        repository.deleteById(id);

    }
}