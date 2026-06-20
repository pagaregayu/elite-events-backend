package com.eliteevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eliteevents.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}