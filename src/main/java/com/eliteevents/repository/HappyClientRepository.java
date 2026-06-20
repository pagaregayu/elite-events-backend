package com.eliteevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eliteevents.entity.HappyClient;

@Repository
public interface HappyClientRepository
        extends JpaRepository<HappyClient, Long> {

}