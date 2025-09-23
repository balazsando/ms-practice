package com.balazsando.jobms.job.business.exception;

public class JobNotFoundException extends RuntimeException {
    public JobNotFoundException(Long id) {
        super("Job with id " + id + " not found");
    }
}
