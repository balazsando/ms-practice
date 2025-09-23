package com.balazsando.jobms.job.business.service;

import com.balazsando.jobms.job.business.domain.Job;
import com.balazsando.jobms.job.business.exception.JobNotFoundException;
import com.balazsando.jobms.job.dataaccess.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository repository;

    @Autowired
    public JobServiceImpl(JobRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Job> getAllJobs() {
        return repository.findAll();
    }

    @Override
    public Job createJob(Job job) {
        return repository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return repository.findById(id).orElseThrow(() -> new JobNotFoundException(id));
    }

    @Override
    public void deleteJob(Long id) {
        validateJobExists(id);

        repository.deleteById(id);
    }

    @Override
    public Job updateJob(Long id, Job job) {
        validateJobExists(id);

        job.setId(id);
        return repository.save(job);
    }

    private void validateJobExists(Long jobId) {
        if (!repository.existsById(jobId)) {
            throw new JobNotFoundException(jobId);
        }
    }
}
