package com.example.wsb.application;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public List<Application> getApplications(){
        return applicationService.getAllApplications();
    }

    @GetMapping("/{id}")
    public Application getApplication(
            @PathVariable Integer id
    ){
        return applicationService.getApplication(id);
    }

    @PostMapping
    public void createApplication(
            @RequestBody ApplicationCreationRequest request){
        applicationService.createApplication(request);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void createApplicationWithFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("userId") Integer userId,
            @RequestParam("jobPostId") Integer jobPostId
    ) {
        applicationService.createApplicationWithFile(file, userId, jobPostId);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(
            @PathVariable("applicationId") Integer id
    ){
        applicationService.deleteApplicationById(id);
    }

    @PatchMapping("/{id}/candidate/{candidateId}")
    public ResponseEntity addCandidateToApplication(
            @PathVariable int id, @PathVariable int candidateId
    ){
        applicationService.addCandidateToApplication(id,candidateId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/candidate")
    public ResponseEntity removeCandidateFromApplication(
            @PathVariable int id
    ){
        applicationService.removeCandidateFromApplication(id);
        return  ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity changeStatus(
            @PathVariable Integer id,
            @RequestParam ApplicationStatus status
    ) {
        applicationService.changeStatusOfApplication(id, status);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    public List<Application> getApplicationsForUser(
            @PathVariable Integer userId
    ) {
        return applicationService.getApplicationsForUser(userId);
    }

}
