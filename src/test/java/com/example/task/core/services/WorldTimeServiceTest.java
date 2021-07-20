package com.example.task.core.services;

import static org.mockito.Mockito.when;

import com.example.task.db.models.WorldTimeEntity;
import com.example.task.db.repository.WorldTimeRepository;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class WorldTimeServiceTest {

  @Mock
  private WorldTimeRepository repository;
  @Mock
  private ApiCallService apiCallService;
  @InjectMocks
  private WorldTimeService service;

  @BeforeEach
  void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void getAll_returnsListOfWorldTimesFromRepo() {
    WorldTimeEntity worldTimeEntity = WorldTimeEntity.builder().id(1L).build();
    List<WorldTimeEntity> entityList = Collections.singletonList(worldTimeEntity);

    when(repository.findAll()).thenReturn(entityList);

    List<WorldTimeEntity> actualResult = service.getAll();

    Assertions.assertThat(actualResult).containsExactlyElementsOf(entityList);
  }

  @Test
  void saveWorldTime_retrievesObjectFromApiThenSaves() {
    String url = "http://worldtimeapi.org/api/ip";
    WorldTimeEntity worldTimeEntity = WorldTimeEntity.builder().id(1L).build();

    when(apiCallService.get(url, WorldTimeEntity.class)).thenReturn(worldTimeEntity);
    when(repository.save(worldTimeEntity)).thenReturn(worldTimeEntity);

    WorldTimeEntity actualResult = service.saveWorldTime();

    Assertions.assertThat(actualResult).isEqualTo(worldTimeEntity);
  }

}
