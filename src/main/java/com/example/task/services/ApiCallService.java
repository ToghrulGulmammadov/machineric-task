package com.example.task.services;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ApiCallService {

  private final RestTemplate restTemplate = new RestTemplate();

  public <T> T get(String url, Class<T> classType) {
    ResponseEntity<T> response = restTemplate.getForEntity(url, classType);
    return Optional.ofNullable(response.getBody()).orElseThrow(
        () -> new IllegalStateException("Response body is null")
    );
  }

}
