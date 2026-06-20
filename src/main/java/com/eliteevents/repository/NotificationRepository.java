package com.eliteevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eliteevents.entity.Notification;

public interface NotificationRepository
        extends JpaRepository<Notification, Long> {

    long countByReadStatusFalse();

}