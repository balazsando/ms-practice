package com.balazsando.jobms.job.dataaccess.repository;

import com.balazsando.jobms.job.business.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
