package com.balazsando.companyms.company.business.service;

import com.balazsando.companyms.company.business.domain.Company;
import com.balazsando.companyms.company.business.exception.CompanyNotFoundException;
import com.balazsando.companyms.company.dataaccess.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return repository.findAll();
    }

    @Override
    public Company createCompany(Company company) {
        return repository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return repository.findById(id).orElseThrow(() -> new CompanyNotFoundException(id));
    }

    @Override
    public void deleteCompany(Long id) {
        if (!repository.existsById(id)) {
            throw new CompanyNotFoundException(id);
        }

        repository.deleteById(id);
    }

    @Override
    public Company updateCompany(Long id, Company company) {
        if (!repository.existsById(id)) {
            throw new CompanyNotFoundException(id);
        }

        company.setId(id);
        return repository.save(company);
    }
}
