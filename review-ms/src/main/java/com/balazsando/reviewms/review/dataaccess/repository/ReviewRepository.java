package com.balazsando.reviewms.review.dataaccess.repository;

import com.balazsando.reviewms.review.business.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByCompanyId(Long companyId);
}
