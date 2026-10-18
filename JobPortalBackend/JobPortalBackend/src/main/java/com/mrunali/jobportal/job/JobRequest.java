package com.mrunali.jobportal.job;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record JobRequest(
    @NotBlank @Size(max = 120) String title,
    @NotBlank @Size(max = 120) String company,
    @NotBlank @Size(max = 80) String location,
    @NotBlank @Size(max = 2000) String description,
    @NotNull EmploymentType employmentType
) {}
