package com.example.wsb.chatgpt;

import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ChatGPTService {

    private final ChatGPT chatGPT;

    public String generateText(String prompt) throws IOException {
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"),
                "{ \"prompt\": \"" + prompt + "\", \"max_tokens\": 500 }"
        );

        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/engines/davinci-codex/completions")
                .post(body)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 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")
                .build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }
}
