package com.balazsando.jobms.job.business.exception;

public class CompanyNotFoundInJobContextException extends RuntimeException {
    public CompanyNotFoundInJobContextException(Long companyId) {
        super("Referenced company with id " + companyId + " not found");
    }
}
