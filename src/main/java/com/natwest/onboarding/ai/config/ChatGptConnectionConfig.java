package com.natwest.onboarding.ai.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "data.source.ai.chatgpt")
@Data
public class ChatGptConnectionConfig {

    private ApiConfig apiConfig;
    private int maxCompletions;
    private int maxTokens;
    private String model;
    private double temperature;
}
