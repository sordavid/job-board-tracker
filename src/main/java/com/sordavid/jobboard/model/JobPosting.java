package com.sordavid.jobboard.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * An entity is a Java object that JPA stores as a database record.
 * Each JobPosting object will become one row in the job_postings table.
 */

@Entity
@Table(name="job_postings")
public class JobPosting {
    /*
     * The database generates a unique ID for each job posting.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String jobTitle;

    private String location;

    @Column(length = 1000)
    private String jobUrl;
    /*
     * EnumType.STRING stores values such as "APPLIED" instead of numbers.
     * String values remain understandable if the enum order changes.
     */

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationStatus status = ApplicationStatus.SAVED;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    
    /*
     * JPA requires a constructor with no arguments.
     */
    protected JobPosting() {
    }

    public JobPosting(
        String companyName,
        String jobTitle,
        String location,
        String jobUrl) {
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.location = location;
        this.jobUrl = jobUrl;
        }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobUrl() {
        return jobUrl;
    }

    public void setJobUrl(String jobUrl) {
        this.jobUrl = this.jobUrl;
    }
    
    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}





