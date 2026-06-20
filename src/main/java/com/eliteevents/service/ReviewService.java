package com.eliteevents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliteevents.entity.Review;
import com.eliteevents.repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    public Review saveReview(Review review) {

        return repository.save(review);

    }

    public List<Review> getAllReviews() {

        return repository.findAll();

    }

    public void deleteReview(Long id) {

        repository.deleteById(id);

    }
}