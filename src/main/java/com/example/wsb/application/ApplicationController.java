package com.example.wsb.application;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{applicationId}")
    public Application getApplication(
            @PathVariable("applicationId") Integer applicationId
    ){
        return applicationService.getApplication(applicationId);
    }

    @PostMapping
    public void createApplication(
            @RequestBody ApplicationCreationRequest request){
        applicationService.createApplication(request);
    }

    @DeleteMapping("{applicationId}")
    public void deleteApplication(
            @PathVariable("applicationId") Integer applicationId
    ){
        applicationService.deleteApplicationById(applicationId);
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

}
