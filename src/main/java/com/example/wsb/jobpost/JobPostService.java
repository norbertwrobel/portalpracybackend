package com.example.wsb.jobpost;

import com.example.wsb.exception.ResourceNotFoundException;
import com.example.wsb.user.companyhr.CompanyHR;
import com.example.wsb.user.companyhr.CompanyHRDao;
import com.example.wsb.user.companyhr.CompanyHRRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Builder
@Service
@RequiredArgsConstructor
public class JobPostService {

    private final JobPostDao jobPostDao;
    private final CompanyHRRepository companyHRRepository;
    private final JobPostRepository jobPostRepository;


    public void createJobPost(JobPostCreationRequest creationRequest) {


        JobPost jobPost = JobPost.builder()
                .title(creationRequest.title())
                .description(creationRequest.description())
                .requirements(creationRequest.requirements())
                .salary(creationRequest.salary())
                .build();

        jobPostDao.insertJobPost(jobPost);
    }

    public void deleteJobPostById(Integer jobPostId) {
        if (!jobPostDao.existsJobPostWithId(jobPostId)) {
            throw new ResourceNotFoundException(
                    "JobPost with id [%s] not found".formatted(jobPostId)
            );
        }
        jobPostDao.deleteJobPostById(jobPostId);
    }

    public void addCompanyHrToJobPost(int id, int companyHrId) {
        JobPost jobPost = jobPostRepository.findById(id).orElseThrow();
        CompanyHR companyHR = companyHRRepository.findById(companyHrId).orElseThrow();
        jobPost.addCompanyHr(companyHR);
    }

    public void removeCompanyHrToJobPost(int id) {
        JobPost jobPost = jobPostRepository.findById(id).orElseThrow();
        jobPost.removeCompanyHr();
    }

    public List<JobPost> getAllJobPosts() {
        return jobPostRepository.findAll();
    }

    public JobPost getJobPost(Integer jobPostId) {
        return jobPostRepository.findById(jobPostId).orElseThrow();
    }


}
