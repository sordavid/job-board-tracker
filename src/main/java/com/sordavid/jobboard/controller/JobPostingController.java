package com.sordavid.jobboard.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.sordavid.jobboard.model.JobPosting;
import com.sordavid.jobboard.repository.JobPostingRepository;

import jakarta.validation.Valid;
import com.sordavid.jobboard.dto.CreateJobPostingRequest;


@RestController
@RequestMapping("/api")
public class JobPostingController {

    private final JobPostingRepository repository;

    public JobPostingController(JobPostingRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/get-all-jobs")
    public List<JobPosting> getAllJobs() {
        return repository.findAll();
    }

    @PostMapping("/jobs")
    @ResponseStatus(HttpStatus.CREATED)
    public JobPosting createJob(@Valid @RequestBody CreateJobPostingRequest request) {
        JobPosting jobPosting = new JobPosting(
                request.companyName(),
                request.jobTitle(),
                request.location(),
                request.jobUrl());
        
        return repository.save(jobPosting);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<JobPosting> getJobById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}