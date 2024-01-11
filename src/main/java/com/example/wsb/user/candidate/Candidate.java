package com.example.wsb.user.candidate;

import com.example.wsb.application.Application;
import com.example.wsb.jobpost.JobPost;
import com.example.wsb.user.Role;
import com.example.wsb.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("candidate")
@SuperBuilder
public class Candidate extends User {

    @OneToMany(mappedBy = "userId")
    private List<Application> applications;

}
