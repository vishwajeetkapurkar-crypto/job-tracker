package com.vishwajeet.job_tracker.service;

import com.vishwajeet.job_tracker.entity.Job;
import com.vishwajeet.job_tracker.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAll() {
        return jobRepository.findAll();
    }

    public Job create(Job job) {
        return jobRepository.save(job);
    }

    public Job update(int id, Job updated) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        job.setCompany(updated.getCompany());
        job.setRole(updated.getRole());
        job.setStatus(updated.getStatus());
        job.setAppliedDate(updated.getAppliedDate());
        job.setSource(updated.getSource());
        job.setNotes(updated.getNotes());

        return jobRepository.save(job);
    }

    public void delete(int id) {
        jobRepository.deleteById(id);
    }
}