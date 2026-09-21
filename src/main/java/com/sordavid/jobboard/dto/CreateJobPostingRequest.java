package com.sordavid.jobboard.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateJobPostingRequest(
        @NotBlank 
        String companyName,
        @NotBlank 
        String jobTitle,
        String location,
        @Size(max = 1000) String jobUrl) {
    }