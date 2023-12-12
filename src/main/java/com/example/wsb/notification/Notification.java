package com.example.wsb.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
public class Notification {
    private int notificationID;
    private int userID;
    private String message;
    private String status;
}
