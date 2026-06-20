package com.eliteevents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliteevents.entity.Notification;
import com.eliteevents.repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    public Notification saveNotification(
            Notification notification) {

        return repository.save(notification);

    }

    public List<Notification> getAllNotifications() {

        return repository.findAll();

    }

    public void deleteNotification(Long id) {

        repository.deleteById(id);

    }
}