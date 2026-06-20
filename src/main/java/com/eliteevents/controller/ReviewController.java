package com.eliteevents.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eliteevents.entity.Review;
import com.eliteevents.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin("*")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @PostMapping
    public Review addReview(
            @RequestBody Review review) {

        return service.saveReview(review);

    }

    @GetMapping
    public List<Review> getAllReviews() {

        return service.getAllReviews();

    }

    @DeleteMapping("/{id}")
    public void deleteReview(
            @PathVariable Long id) {

        service.deleteReview(id);

    }
}