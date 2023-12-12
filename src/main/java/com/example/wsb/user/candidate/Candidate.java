package com.example.wsb.user.candidate;

import com.example.wsb.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor

@Entity
public class Candidate extends User {
    @Id
    private int candidateID;
    private int userID;
    private int companyHR_ID;
    private int applicationID;
}
