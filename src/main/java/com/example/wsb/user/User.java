package com.example.wsb.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor@AllArgsConstructor
@Entity
public class User {
    @Id
    private int userID;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String role;
}
