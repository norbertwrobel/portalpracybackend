package com.example.wsb.jobpost;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/jobposts")
public class JobPostController {
    private final JobPostService jobPostService;

    public JobPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @GetMapping
    public List<JobPost> getJobPosts(){
        return jobPostService.getAllJobPosts();
    }

    @GetMapping("{id}")
    public JobPost getJobPost(
            @PathVariable("id") Integer jobPostId
    ){
        return jobPostService.getJobPost(jobPostId);
    }

    @PostMapping
    public void createJobPost(
            @RequestBody JobPostCreationRequest request){
        jobPostService.createJobPost(request);
    }

    @DeleteMapping("{id}")
    public void deleteJobPost(
            @PathVariable("id") Integer jobPostId
    ){
        jobPostService.deleteJobPostById(jobPostId);
    }

    @PatchMapping("/{id}/companyHr/{companyHrId}")
    public ResponseEntity addCompanyHrToJobPost(
            @PathVariable int id, @PathVariable int companyHrId
    ){
        jobPostService.addCompanyHrToJobPost(id,companyHrId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/companyHr")
    public ResponseEntity removeCompanyHrFromJobPost(
            @PathVariable int id
    ){
        jobPostService.removeCompanyHrFromJobPost(id);
        return ResponseEntity.ok().build();
    }

}
