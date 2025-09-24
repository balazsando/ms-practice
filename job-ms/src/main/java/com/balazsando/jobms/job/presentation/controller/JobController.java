package com.balazsando.jobms.job.presentation.controller;

import com.balazsando.jobms.job.business.domain.Job;
import com.balazsando.jobms.job.business.domain.JobWithCompany;
import com.balazsando.jobms.job.business.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobService service;

    @Autowired
    public JobController(JobService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<JobWithCompany>> findAll() {
        return ResponseEntity.ok(service.getAllJobs());
    }

    @PostMapping("")
    public ResponseEntity<JobWithCompany> addJob(@Valid @RequestBody Job job) {
        return new ResponseEntity<>(service.createJob(job), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobWithCompany> getJob(@PathVariable Long id) {
        return ResponseEntity.ok(service.getJobById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        service.deleteJob(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobWithCompany> updateJob(@PathVariable Long id, @Valid @RequestBody Job job) {
        return ResponseEntity.ok(service.updateJob(id, job));
    }
}
