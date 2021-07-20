package com.example.task.api;

import com.example.task.core.services.PollSchedulerService;
import com.example.task.core.services.WorldTimeService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poll")
public class PollController {

  private final PollSchedulerService pollSchedulerService;
  private final WorldTimeService worldTimeService;

  @GetMapping("/start/{interval}")
  public ResponseEntity<String> start(@PathVariable Optional<Integer> interval) {
    pollSchedulerService.startScheduler(interval, worldTimeService::saveWorldTime);
    return new ResponseEntity<>("Data pulling started successfully!", HttpStatus.OK);
  }

  @GetMapping("/stop")
  public ResponseEntity<String> stop() {
    pollSchedulerService.stopScheduler();
    return new ResponseEntity<>("Data pulling stopped!", HttpStatus.OK);
  }

}
