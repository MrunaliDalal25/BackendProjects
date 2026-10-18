package com.mrunali.jobportal.job;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class JobService {
    private final JobRepository repository;

    public JobService(JobRepository repository) { this.repository = repository; }

    public Job create(JobRequest request) {
        Job job = new Job();
        apply(job, request);
        return repository.save(job);
    }

    public List<Job> findAll(String keyword) {
        if (keyword == null || keyword.isBlank()) return repository.findAll();
        return repository.search(keyword.trim());
    }

    public Job findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Job not found: " + id));
    }

    public Job update(Long id, JobRequest request) {
        Job job = findById(id);
        apply(job, request);
        return repository.save(job);
    }

    public void delete(Long id) {
        Job job = findById(id);
        repository.delete(job);
    }

    private void apply(Job job, JobRequest request) {
        job.setTitle(request.title().trim());
        job.setCompany(request.company().trim());
        job.setLocation(request.location().trim());
        job.setDescription(request.description().trim());
        job.setEmploymentType(request.employmentType());
    }
}
