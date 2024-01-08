package com.example.wsb.user.companyhr;

import com.example.wsb.jobpost.JobPost;
import com.example.wsb.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
public class CompanyHR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyHrId;

    @OneToOne(mappedBy = "companyHrId")
    private User userId;

    @OneToMany(mappedBy = "companyHrId")
    private List<JobPost> jobPosts;

    private int jobID;
}
