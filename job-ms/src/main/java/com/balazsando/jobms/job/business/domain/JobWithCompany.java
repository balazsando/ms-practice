package com.balazsando.jobms.job.business.domain;

import com.balazsando.jobms.company.business.domain.Company;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobWithCompany {
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    private Company company;

    public static JobWithCompany fromJob(Job job, Company company) {
        return new JobWithCompany(
            job.getId(),
            job.getTitle(),
            job.getDescription(),
            job.getMinSalary(),
            job.getMaxSalary(),
            job.getLocation(),
            company
        );
    }
}