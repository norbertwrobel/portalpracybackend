package com.example.wsb.application;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Data@NoArgsConstructor@AllArgsConstructor
@Entity
public class Application {
    @GeneratedValue
    @Id
    private int applicationID;
    private int jobID;
    private int candidateID;

    @Column
    private String status;
    private File attachment;
}
