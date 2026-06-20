package com.eliteevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eliteevents.entity.Review;

@Repository
public interface ReviewRepository
        extends JpaRepository<Review, Long> {

}