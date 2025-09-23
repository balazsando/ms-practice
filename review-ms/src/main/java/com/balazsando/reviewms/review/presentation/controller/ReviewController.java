package com.balazsando.reviewms.review.presentation.controller;


import com.balazsando.reviewms.review.business.domain.Review;
import com.balazsando.reviewms.review.business.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService service;

    @Autowired
    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<Review>> getCompanyReviews(@RequestParam Long companyId) {
        return ResponseEntity.ok(service.getCompanyReviews(companyId));
    }

    @PostMapping("")
    public ResponseEntity<Review> addCompanyReview(@RequestParam Long companyId, @Valid @RequestBody Review review) {
        return new ResponseEntity<>(service.createCompanyReview(companyId, review), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getCompanyReview(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCompanyReviewById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyReview(@PathVariable Long id) {
        service.deleteCompanyReview(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateCompanyReview(@PathVariable Long id, @Valid @RequestBody Review review) {
        return ResponseEntity.ok(service.updateCompanyReview(id, review));
    }
}
