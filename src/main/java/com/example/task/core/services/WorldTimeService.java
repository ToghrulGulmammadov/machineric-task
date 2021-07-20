package com.example.task.core.services;

import com.example.task.db.models.WorldTimeEntity;
import com.example.task.db.repository.WorldTimeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorldTimeService {

  private static final String URL = "http://worldtimeapi.org/api/ip";
  private final WorldTimeRepository repository;
  private final ApiCallService apiCallService;

  public WorldTimeEntity saveWorldTime() {
    WorldTimeEntity worldTime = apiCallService.get(URL, WorldTimeEntity.class);
    return repository.save(worldTime);
  }

  public List<WorldTimeEntity> getAll() {
    return repository.findAll();
  }

}
