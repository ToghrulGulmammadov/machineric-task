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

  public void startScheduler(Runnable runnableMethod) {
    scheduledFuture = taskScheduler.scheduleAtFixedRate(runnableMethod, INTERVAL_10_SEC);
  }

  public void updateScheduler(Optional<Integer> intervalOptional, Runnable runnableMethod) {
    stopScheduler();

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
