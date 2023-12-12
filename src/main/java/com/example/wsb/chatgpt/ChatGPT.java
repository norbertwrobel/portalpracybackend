package com.example.wsb.chatgpt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor

public class ChatGPT {

    @Column
    private String apiKey;
}
