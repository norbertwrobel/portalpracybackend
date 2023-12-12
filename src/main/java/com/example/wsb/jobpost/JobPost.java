package com.example.wsb.jobpost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
public class JobPost {
    private int jobID;
    private int companyHR_ID;
    private String title;
    private String description;
    private String requirements;
    private int salary;
}
