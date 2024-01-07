package com.example.wsb.user.companyhr;

import com.example.wsb.jobpost.JobPost;
import com.example.wsb.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor

@Entity
public class CompanyHR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyHR_ID;

    @OneToOne(mappedBy = "companyHR_ID")
    private User userId;

    private int jobID;
}
