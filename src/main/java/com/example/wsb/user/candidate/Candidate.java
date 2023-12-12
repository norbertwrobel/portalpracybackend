package com.example.wsb.user.candidate;

import com.example.wsb.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor

public class Candidate extends User {
    private int candidateID;
    private int userID;
    private int companyHR_ID;
    private int applicationID;
}
