package com.balazsando.companyms.company.presentation.controller;

import com.balazsando.companyms.company.business.domain.Company;
import com.balazsando.companyms.company.business.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService service;

    @Autowired
    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(service.getAllCompanies());
    }

    @PostMapping("")
    public ResponseEntity<Company> addCompany(@Valid @RequestBody Company company) {
        return new ResponseEntity<>(service.createCompany(company), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCompanyById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        service.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @Valid @RequestBody Company company) {
        return ResponseEntity.ok(service.updateCompany(id, company));
    }
}
