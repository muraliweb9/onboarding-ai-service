package com.natwest.onboarding.ai.controller;

import com.natwest.onboarding.ai.model.Message;
import com.natwest.onboarding.ai.model.Request;
import com.natwest.onboarding.ai.model.Response;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ChatGptController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.max-completions}")
    private int maxCompletions;

    @Value("${openai.temperature}")
    private double temperature;

    @Value("${openai.max_tokens}")
    private int maxTokens;

    @Value("${openai.api.url}")
    private String apiUrl;

    @PostMapping("/chat")
    public Response chat(@RequestParam("prompt") String prompt) {

        Request request =
                new Request(model, List.of(new Message("user", prompt)), maxCompletions, temperature, maxTokens);

        Response response = restTemplate.postForObject(apiUrl, request, Response.class);
        return response;
    }
}
