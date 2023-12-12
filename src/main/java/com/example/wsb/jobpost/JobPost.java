package com.example.wsb.jobpost;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
public class JobPost {

    @GeneratedValue
    @Id
    private int jobID;
    private int companyHR_ID;

    @Column
    private String title;

    @Column
    @Lob
    private String description;

    @Column
    private String requirements;

    @Column
    private int salary;
}
