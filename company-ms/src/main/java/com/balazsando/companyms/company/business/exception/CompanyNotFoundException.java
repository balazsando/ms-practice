package com.balazsando.companyms.company.business.exception;

public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException(Long id) {
        super("Company with id " + id + " not found");
    }
}
