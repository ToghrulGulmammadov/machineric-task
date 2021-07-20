package com.example.task.api;

import com.example.task.core.services.WorldTimeService;
import com.example.task.db.models.WorldTimeEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WorldTimeController {

  private final WorldTimeService worldTimeService;

  @GetMapping("/data")
  public ResponseEntity<List<WorldTimeEntity>> get() {
    List<WorldTimeEntity> worldTimeList = worldTimeService.getAll();
    return new ResponseEntity<>(worldTimeList, HttpStatus.OK);
  }

}
