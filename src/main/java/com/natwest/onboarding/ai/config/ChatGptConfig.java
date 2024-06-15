package com.natwest.onboarding.ai.config;

import com.natwest.onboarding.ai.interceptor.RequestResponseLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ChatGptConfig {

    @Bean
    public RestTemplate restTemplate(ChatGptConnectionConfig connectionConfig_) {

        //        String apiKey = connectionConfig.getApiConfig().getKey();
        String apiKey = System.getProperty("chat.gpt.api.key");

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + apiKey);
            return execution.execute(request, body);
        });

        restTemplate.getInterceptors().add(new RequestResponseLoggingInterceptor());
        restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        return restTemplate;
    }
}
