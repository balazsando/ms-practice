package com.balazsando.companyms.company.presentation.advice;

import com.balazsando.companyms.company.business.exception.CompanyNotFoundException;
import com.balazsando.companyms.company.presentation.controller.CompanyController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice(assignableTypes = {CompanyController.class})
public class CompanyExceptionHandler {

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseStatusException handleCompanyNotFound(CompanyNotFoundException ex) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
