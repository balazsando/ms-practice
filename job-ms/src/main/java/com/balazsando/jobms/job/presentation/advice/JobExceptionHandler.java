package com.balazsando.jobms.job.presentation.advice;

import com.balazsando.jobms.job.business.exception.CompanyNotFoundInJobContextException;
import com.balazsando.jobms.job.business.exception.JobNotFoundException;
import com.balazsando.jobms.job.presentation.controller.JobController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice(assignableTypes = JobController.class)
public class JobExceptionHandler {

    @ExceptionHandler(JobNotFoundException.class)
    public ResponseStatusException handleJobNotFound(JobNotFoundException ex) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(CompanyNotFoundInJobContextException.class)
    public ResponseStatusException handleJobNotFound(CompanyNotFoundInJobContextException ex) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
