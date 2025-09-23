package com.balazsando.reviewms.review.business.service;



import com.balazsando.reviewms.review.business.domain.Review;
import jakarta.validation.Valid;

import java.util.List;

public interface ReviewService {
    List<Review> getCompanyReviews(Long companyId);

    Review createCompanyReview(Long companyId, Review review);

    Review getCompanyReviewById(Long id);

    void deleteCompanyReview(Long id);

    Review updateCompanyReview(Long id, @Valid Review review);
}
