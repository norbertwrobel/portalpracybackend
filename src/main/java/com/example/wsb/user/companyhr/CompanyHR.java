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
@DiscriminatorValue("companyHr")
public class CompanyHR extends User {

    @OneToMany(mappedBy = "companyHr", cascade = CascadeType.REMOVE)
    private List<JobPost> jobPosts;

}
