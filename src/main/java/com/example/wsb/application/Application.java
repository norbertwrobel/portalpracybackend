package com.example.wsb.application;

import com.example.wsb.jobpost.JobPost;
import com.example.wsb.user.User;
import com.example.wsb.user.candidate.Candidate;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import com.example.wsb.application.file.File;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@SuperBuilder
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applicationId;

    @Enumerated(EnumType.STRING)
    @Column
    private ApplicationStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fileId")
    private File file;

    @ManyToOne
    @JoinColumn(name = "userId")
    @ToString.Exclude
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "jobId")
    @ToString.Exclude
    private JobPost jobPost;

    public void addCandidate(Candidate candidate){
        setCandidate(candidate);
    }

    public void removeCandidate(){
        setCandidate(null);
    }
}
