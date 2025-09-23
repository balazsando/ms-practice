package com.balazsando.companyms.company.business.service;

import com.balazsando.companyms.company.business.domain.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    Company createCompany(Company company);

    Company getCompanyById(Long id);

    void deleteCompany(Long id);

    Company updateCompany(Long id, Company company);
}
