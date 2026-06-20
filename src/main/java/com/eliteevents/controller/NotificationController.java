package com.eliteevents.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eliteevents.entity.Notification;
import com.eliteevents.repository.NotificationRepository;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin("*")
public class NotificationController {

    @Autowired
    private NotificationRepository repository;

    @PostMapping
    public Notification addNotification(
            @RequestBody Notification notification) {

        return repository.save(notification);
    }

    @GetMapping
    public List<Notification> getAllNotifications() {

        return repository.findAll();

    }

    @GetMapping("/count")
    public long getUnreadCount() {

        return repository.countByReadStatusFalse();

    }

    @PutMapping("/mark-all-read")
    public void markAllRead() {

        List<Notification> notifications =
                repository.findAll();

        for (Notification notification : notifications) {

            notification.setReadStatus(true);

        }

        repository.saveAll(notifications);

    }

    @DeleteMapping("/{id}")
    public void deleteNotification(
            @PathVariable Long id) {

        repository.deleteById(id);

    }
}