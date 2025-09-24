package com.balazsando.jobms.job.business.service;

import com.balazsando.jobms.company.business.domain.Company;
import com.balazsando.jobms.job.business.port.CompanyPort;
import com.balazsando.jobms.job.business.domain.Job;
import com.balazsando.jobms.job.business.domain.JobWithCompany;
import com.balazsando.jobms.job.business.exception.JobNotFoundException;
import com.balazsando.jobms.job.dataaccess.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository repository;
    private final CompanyPort companyPort;

    @Autowired
    public JobServiceImpl(JobRepository repository, CompanyPort companyPort) {
        this.repository = repository;
        this.companyPort = companyPort;
    }

    @Override
    public List<JobWithCompany> getAllJobs() {
        List<Job> jobs = repository.findAll();

        return jobs.stream()
                .map(this::enrichJobWithCompany)
                .toList();
    }

    @Override
    public JobWithCompany createJob(Job job) {
        Company company = companyPort.getCompanyById(job.getCompanyId());
        Job savedJob = repository.save(job);

        return JobWithCompany.fromJob(savedJob, company);
    }

    @Override
    public JobWithCompany getJobById(Long id) {
        Job job = repository.findById(id).orElseThrow(() -> new JobNotFoundException(id));

        return enrichJobWithCompany(job);
    }

    @Override
    public void deleteJob(Long id) {
        validateJobExists(id);

        repository.deleteById(id);
    }

    @Override
    public JobWithCompany updateJob(Long id, Job job) {
        validateJobExists(id);
        Company company = companyPort.getCompanyById(job.getCompanyId());

        job.setId(id);
        Job savedJob = repository.save(job);

        return JobWithCompany.fromJob(savedJob, company);
    }

    private void validateJobExists(Long jobId) {
        if (!repository.existsById(jobId)) {
            throw new JobNotFoundException(jobId);
        }
    }

    private JobWithCompany enrichJobWithCompany(Job job) {
        Company company = companyPort.getCompanyById(job.getCompanyId());

        return JobWithCompany.fromJob(job, company);
    }
}
