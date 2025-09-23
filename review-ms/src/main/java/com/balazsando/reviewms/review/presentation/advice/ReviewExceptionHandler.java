package com.balazsando.reviewms.review.presentation.advice;

import com.balazsando.reviewms.review.business.exception.ReviewNotFoundException;
import com.balazsando.reviewms.review.presentation.controller.ReviewController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice(assignableTypes = {ReviewController.class})
public class ReviewExceptionHandler {

    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseStatusException handleReviewNotFound(ReviewNotFoundException ex) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
