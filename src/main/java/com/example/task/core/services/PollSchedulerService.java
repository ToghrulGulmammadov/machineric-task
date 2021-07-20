package com.example.task.core.services;

import java.util.Optional;
import java.util.concurrent.ScheduledFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PollSchedulerService {

  private static final Integer INTERVAL_10_SEC = 10000;

  private final TaskScheduler taskScheduler;
  private ScheduledFuture<?> scheduledFuture;

  public void startScheduler(Optional<Integer> intervalOptional, Runnable runnableMethod) {
    int interval = intervalOptional.orElse(INTERVAL_10_SEC);
    if (interval < 1) {
      throw new IllegalStateException("Interval must be positive number");
    }
    scheduledFuture = taskScheduler.scheduleAtFixedRate(runnableMethod, interval);
  }

  public void stopScheduler() {
    scheduledFuture.cancel(false);
  }

}
