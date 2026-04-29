package com.vishwajeet.job_tracker.controller;

import com.vishwajeet.job_tracker.entity.Job;
import com.vishwajeet.job_tracker.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin   // IMPORTANT for browser calls
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAll();
    }

    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobService.create(job);
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable int id, @RequestBody Job job) {
        return jobService.update(id, job);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable int id) {
        jobService.delete(id);
    }
}