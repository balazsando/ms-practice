package com.balazsando.jobms.job.business.port;

import com.balazsando.jobms.company.business.domain.Company;
import com.balazsando.jobms.job.business.exception.CompanyNotFoundException;

public interface CompanyPort {

    Company getCompanyById(Long companyId) throws CompanyNotFoundException;
}