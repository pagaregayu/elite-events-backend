package com.eliteevents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliteevents.entity.Event;
import com.eliteevents.repository.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public Event saveEvent(Event event) {
        return repository.save(event);
    }

    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    public Event getEventById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteEvent(Long id) {
        repository.deleteById(id);
    }
}