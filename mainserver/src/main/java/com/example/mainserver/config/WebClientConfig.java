package com.example.mainserver.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Configuration class for WebClient in the application.
 * It defines a bean for WebClient to be used for making reactive HTTP requests.
 *
 * @author prapti
 */
@Configuration
@EnableAutoConfiguration
public class WebClientConfig {

    /**
     * Provides a WebClient bean using the provided WebClient.Builder.
     *
     * @param builder The WebClient.Builder used for building the WebClient bean.
     * @return An instance of WebClient configured for making reactive HTTP requests.
     */
    @Bean
    WebClient webClient(WebClient.Builder builder) {
        return builder.build();
    }
}

