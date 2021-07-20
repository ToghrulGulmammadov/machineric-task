package com.example.task.api;

import com.example.task.core.services.PollingSchedulerService;
import com.example.task.core.services.WorldTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/polling")
public class PollingController {

  private final PollingSchedulerService pollSchedulerService;
  private final WorldTimeService worldTimeService;

  @GetMapping("/start")
  public ResponseEntity<String> start() {
    pollSchedulerService.startScheduler(worldTimeService::saveWorldTime);
    return new ResponseEntity<>("Polling started successfully!", HttpStatus.OK);
  }

  @PutMapping()
  public ResponseEntity<String> update(@RequestParam Integer interval) {
    pollSchedulerService.updateScheduler(interval, worldTimeService::saveWorldTime);
    return new ResponseEntity<>("Polling updated successfully!", HttpStatus.OK);
  }

  @GetMapping("/stop")
  public ResponseEntity<String> stop() {
    pollSchedulerService.stopScheduler();
    return new ResponseEntity<>("Polling stopped!", HttpStatus.OK);
  }

}
