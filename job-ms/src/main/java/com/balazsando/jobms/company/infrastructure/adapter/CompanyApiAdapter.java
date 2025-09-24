package com.balazsando.jobms.company.infrastructure.adapter;

import com.balazsando.jobms.company.business.domain.Company;
import com.balazsando.jobms.job.business.exception.CompanyNotFoundException;
import com.balazsando.jobms.job.business.port.CompanyPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

@Component
public class CompanyApiAdapter implements CompanyPort {

    private static final Logger logger = LoggerFactory.getLogger(CompanyApiAdapter.class);

    private final RestTemplate restTemplate;
    private final String companyServiceBaseUrl;

    @Autowired
    public CompanyApiAdapter(
            RestTemplate restTemplate,
            @Value("${company.service.base-url:http://company-ms:8081}") String companyServiceBaseUrl
    ) {
        this.restTemplate = restTemplate;
        this.companyServiceBaseUrl = companyServiceBaseUrl;
    }

    @Override
    public Company getCompanyById(Long companyId) throws CompanyNotFoundException {
        try {
            String url = companyServiceBaseUrl + "/companies/" + companyId;
            logger.debug("Fetching company with ID {} from URL: {}", companyId, url);

            Company company = restTemplate.getForObject(url, Company.class);
            if (company == null) {
                throw new CompanyNotFoundException(companyId);
            }
            return company;

        } catch (RestClientException e) {
            logger.warn("Failed to fetch company with ID {}: {}", companyId, e.getMessage());
            throw new CompanyNotFoundException(companyId);
        }
    }
}