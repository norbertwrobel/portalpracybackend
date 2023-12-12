package com.example.wsb.application;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Data@NoArgsConstructor@AllArgsConstructor
@Entity
public class Application {
    @Id
    private int applicationID;
    private int jobID;
    private int candidateID;
    private String status;
    private File attachment;
}
