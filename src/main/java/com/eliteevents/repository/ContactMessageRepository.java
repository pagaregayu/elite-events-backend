package com.eliteevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eliteevents.entity.ContactMessage;

public interface ContactMessageRepository
        extends JpaRepository<ContactMessage, Long> {

}