package com.natwest.onboarding.ai.controller;

import com.natwest.onboarding.ai.config.ChatGptConnectionConfig;
import com.natwest.onboarding.ai.model.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ChatGptController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ChatGptConnectionConfig chatGptConnectionConfig;

    @PostMapping("/prompt")
    public Response chat(@RequestBody ClientRequest req) {

        Request request = new Request(
                chatGptConnectionConfig.getModel(),
                List.of(new Message("user", req.getPrompt())),
                chatGptConnectionConfig.getMaxCompletions(),
                chatGptConnectionConfig.getTemperature(),
                chatGptConnectionConfig.getMaxTokens());

        Response response = restTemplate.postForObject(
                chatGptConnectionConfig.getApiConfig().getUrl(), request, Response.class);
        return response;
    }

    @PostMapping("/detailed-prompt")
    public Response chat(@RequestBody ClientDetailedRequest req) {

        Request request = new Request(
                req.getModel(),
                List.of(new Message("user", req.getPrompt())),
                req.getMaxCompletions(),
                req.getTemperature(),
                req.getMaxTokens());

        Response response = restTemplate.postForObject(
                chatGptConnectionConfig.getApiConfig().getUrl(), request, Response.class);
        return response;
    }
}
