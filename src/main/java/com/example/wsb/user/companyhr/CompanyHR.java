package com.example.wsb.user.companyhr;

import com.example.wsb.jobpost.JobPost;
import com.example.wsb.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data@AllArgsConstructor@NoArgsConstructor
@Entity
public class CompanyHR extends User {

    @Id
    private int companyHR_ID;

    private int jobID;
}
