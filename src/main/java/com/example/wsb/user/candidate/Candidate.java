package com.example.wsb.user.candidate;

import com.example.wsb.user.Role;
import com.example.wsb.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("candidate")
@SuperBuilder
public class Candidate extends User {
    //@GeneratedValue

//
//    private int userID;
//    private int companyHrId;
    private int applicationID;


//    public Candidate(String firstName, String lastName, String username, String password, String email, Role role) {
//        super(firstName, lastName, username, password, email, role);
//    }
}
