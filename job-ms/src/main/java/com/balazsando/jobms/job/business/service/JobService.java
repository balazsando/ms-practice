package com.balazsando.jobms.job.business.service;


import com.balazsando.jobms.job.business.domain.Job;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();

    Job createJob(Job job);

    Job getJobById(Long id);

    void deleteJob(Long id);

    Job updateJob(Long id, Job job);
}
