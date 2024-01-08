package com.example.wsb.user.admin;

import com.example.wsb.user.User;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("admin")
public class Admin extends User {

    private User userId
}
