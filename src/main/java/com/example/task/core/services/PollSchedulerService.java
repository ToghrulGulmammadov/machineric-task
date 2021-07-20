package com.example.task.core.services;

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

  public void updateScheduler(Integer interval, Runnable runnableMethod) {
    if (interval < 1) {
      throw new IllegalStateException("Interval must be positive number");
    }
    stopScheduler();

    scheduledFuture = taskScheduler.scheduleAtFixedRate(runnableMethod, interval);
  }

  public void stopScheduler() {
    scheduledFuture.cancel(false);
  }

}
