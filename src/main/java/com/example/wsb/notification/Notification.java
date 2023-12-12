package com.example.wsb.notification;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
public class Notification {
    @GeneratedValue
    @Id
    private int notificationID;
    private int userID;

    @Column
    @Lob
    private String message;

    @Column
    private String status;
}
