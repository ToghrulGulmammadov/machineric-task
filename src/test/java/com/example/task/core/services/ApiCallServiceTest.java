package com.example.task.core.services;

import static org.mockito.Mockito.when;

import com.example.task.db.models.WorldTimeEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

class ApiCallServiceTest {

  private static final String URL = "http://worldtimeapi.org/api/ip";
  @Mock
  private RestTemplate template;
  @InjectMocks
  private ApiCallService service;

  @BeforeEach
  void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void get_returnsResponseBodyIfExists() {
    WorldTimeEntity entity = WorldTimeEntity.builder().id(1L).build();
    ResponseEntity<WorldTimeEntity> responseEntity = new ResponseEntity<>(entity, HttpStatus.OK);

    when(template.getForEntity(URL, WorldTimeEntity.class)).thenReturn(responseEntity);

    WorldTimeEntity actualResponse = service.get(URL, WorldTimeEntity.class);

    Assertions.assertThat(actualResponse).isEqualTo(entity);
  }

  @Test
  void get_throwsException_whenResponseBodyIsEmpty() {
    ResponseEntity<WorldTimeEntity> responseEntity = new ResponseEntity<>(HttpStatus.OK);

    when(template.getForEntity(URL, WorldTimeEntity.class)).thenReturn(responseEntity);

    Assertions.assertThatIllegalStateException().isThrownBy(
        () -> service.get(URL, WorldTimeEntity.class)
    ).withMessage("Could not retrieve data");
  }

}
