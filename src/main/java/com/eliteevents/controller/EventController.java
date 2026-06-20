package com.eliteevents.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eliteevents.entity.Event;
import com.eliteevents.repository.EventRepository;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "*")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @PostMapping
    public Event addEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Event updateEvent(
            @PathVariable Long id,
            @RequestBody Event event) {

        Event existing =
                eventRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setTitle(event.getTitle());
            existing.setCategory(event.getCategory());
            existing.setLocation(event.getLocation());
            existing.setEventDate(event.getEventDate());
            existing.setImageUrl(event.getImageUrl());

            return eventRepository.save(existing);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventRepository.deleteById(id);
        return "Event Deleted Successfully";
    }
}