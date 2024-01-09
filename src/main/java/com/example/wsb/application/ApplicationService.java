package com.example.wsb.application;

import com.example.wsb.application.file.File;
import com.example.wsb.application.file.FileRepository;
import com.example.wsb.exception.ResourceNotFoundException;
import com.example.wsb.user.candidate.Candidate;
import com.example.wsb.user.candidate.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationDao applicationDao;
    private final ApplicationRepository applicationRepository;
    private final CandidateRepository candidateRepository;
    private final FileRepository fileRepository;



    public List<Application> getAllApplications() {
        return applicationDao.selectAllApplications();
    }

    public Application getApplication(Integer id) {
        return applicationDao.selectApplicationById(id);
    }

    public void createApplication(ApplicationCreationRequest creationRequest) {
        File file = fileRepository.findById(creationRequest.fileId())
                .orElseThrow(() -> new ResourceNotFoundException("File not found"));

        Application application = Application.builder()
                .status(creationRequest.status())
                .file(file)
                .build();

        applicationDao.insertApplication(application);
    }

    public void deleteApplicationById(Integer applicationId) {
        if (!applicationDao.existsApplicationWithId(applicationId)) {
            throw new ResourceNotFoundException(
                    "Application with id [%s] not found".formatted(applicationId)
            );
        }
        applicationDao.deleteApplicationById(applicationId);
    }

    public void addCandidateToApplication(int id, int candidateId){
        Application application = applicationRepository.findById(id).orElseThrow();
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow();
        application.addCandidate(candidate);
    }

    public void removeCandidateFromApplication(int id){
        Application application = applicationRepository.findById(id).orElseThrow();
        application.removeCandidate();
    }
}
