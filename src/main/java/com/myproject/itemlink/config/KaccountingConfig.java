package com.myproject.itemlink.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class KaccountingConfig {

    private final KaccountingProperties properties;

    @Bean
    RestClient kaccountingRestClient() {
        return RestClient.builder()
                .baseUrl(properties.getBaseUrl())
                .defaultHeader("Authorization", "Token " + properties.getToken())
                .defaultHeader("Content-Type", "application/json")
                .requestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
                .requestInterceptor(loggingInterceptor())
                .build();
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static String prettyJson(byte[] bytes) {
        try {
            Object json = objectMapper.readValue(bytes, Object.class);
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
        } catch (Exception e) {
            return new String(bytes, StandardCharsets.UTF_8);
        }
    }

    private ClientHttpRequestInterceptor loggingInterceptor() {
        return (HttpRequest request, byte[] body, ClientHttpRequestExecution execution) -> {
            log.info("[Kaccounting] >>> {} {}", request.getMethod(), request.getURI());
            log.info("[Kaccounting] Request:\n{}", prettyJson(body));

            ClientHttpResponse response = execution.execute(request, body);

            byte[] responseBody = response.getBody().readAllBytes();
            log.info("[Kaccounting] Response ({}):\n{}", response.getStatusCode(), prettyJson(responseBody));

            HttpStatusCode status = response.getStatusCode();
            return new ClientHttpResponse() {
                @Override public HttpStatusCode getStatusCode() throws IOException { return status; }
                @Override public String getStatusText() throws IOException { return ""; }
                @Override public void close() {}
                @Override public InputStream getBody() { return new ByteArrayInputStream(responseBody); }
                @Override public org.springframework.http.HttpHeaders getHeaders() { return response.getHeaders(); }
            };
        };
    }
}
