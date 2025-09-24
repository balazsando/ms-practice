package com.balazsando.jobms.job.business.exception;

public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException(Long companyId) {
        super("Company not found with id: " + companyId);
    }
}