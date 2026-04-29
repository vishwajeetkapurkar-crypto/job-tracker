package com.vishwajeet.job_tracker.repository;

import com.vishwajeet.job_tracker.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {
}
