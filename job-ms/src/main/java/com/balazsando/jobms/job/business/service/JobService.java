package com.balazsando.jobms.job.business.service;

import com.balazsando.jobms.job.business.domain.Job;
import com.balazsando.jobms.job.business.domain.JobWithCompany;

import java.util.List;

public interface JobService {
    List<JobWithCompany> getAllJobs();

    JobWithCompany createJob(Job job);

    JobWithCompany getJobById(Long id);

    void deleteJob(Long id);

    JobWithCompany updateJob(Long id, Job job);
}
