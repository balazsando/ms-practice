package com.balazsando.reviewms.review.business.service;

import com.balazsando.reviewms.review.business.domain.Review;
import com.balazsando.reviewms.review.business.exception.ReviewNotFoundException;
import com.balazsando.reviewms.review.dataaccess.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Review> getCompanyReviews(Long companyId) {
        return repository.findAllByCompanyId(companyId);
    }

    @Override
    public Review createCompanyReview(Long companyId, Review review) {
        review.setCompanyId(companyId);

        return repository.save(review);
    }

    @Override
    public Review getCompanyReviewById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ReviewNotFoundException(id));
    }

    @Override
    public void deleteCompanyReview(Long id) {
        validateReviewExists(id);

        repository.deleteById(id);
    }

    @Override
    public Review updateCompanyReview(Long id, Review review) {
        validateReviewExists(id);

        review.setId(id);
        return repository.save(review);
    }

    private void validateReviewExists(Long reviewId) {
        if (!repository.existsById(reviewId)) {
            throw new ReviewNotFoundException(reviewId);
        }
    }
}
