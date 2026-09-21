package com.sordavid.jobboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sordavid.jobboard.model.JobPosting;

public interface JobPostingRepository
        extends JpaRepository<JobPosting, Long> {
            
        }