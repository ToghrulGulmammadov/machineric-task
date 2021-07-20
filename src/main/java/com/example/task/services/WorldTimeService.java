package com.example.task.services;

import com.example.task.models.WorldTime;
import com.example.task.repository.WorldTimeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorldTimeService {

  private static final String URL = "http://worldtimeapi.org/api/ip";
  private final WorldTimeRepository repository;
  private final ApiCallService apiCallService;

  public WorldTime saveWorldTime() {
    WorldTime worldTime = apiCallService.get(URL, WorldTime.class);
    // TODO: create separate entity and model
    return repository.save(worldTime);
  }

  public List<WorldTime> getAll() {
    return repository.findAll();
  }

}
