package com.mrunali.jobportal.job;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private final JobService service;

    public JobController(JobService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Job create(@Valid @RequestBody JobRequest request) { return service.create(request); }

    @GetMapping
    public List<Job> findAll(@RequestParam(required = false) String keyword) {
        return service.findAll(keyword);
    }

    @GetMapping("/{id}")
    public Job findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public Job update(@PathVariable Long id, @Valid @RequestBody JobRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
