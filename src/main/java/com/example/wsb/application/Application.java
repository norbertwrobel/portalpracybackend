package com.example.wsb.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Data@NoArgsConstructor@AllArgsConstructor
public class Application {
    private int applicationID;
    private int jobID;
    private int candidateID;
    private String status;
    private File attachment;
}
