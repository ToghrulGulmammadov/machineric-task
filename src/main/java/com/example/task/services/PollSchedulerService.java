package com.example.task.services;

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

  public void startScheduler(Optional<Integer> interval, Runnable runnableMethod) {
    scheduledFuture = taskScheduler.scheduleAtFixedRate(runnableMethod, interval.orElse(INTERVAL_10_SEC));
  }

  public void stopScheduler() {
    scheduledFuture.cancel(false);
  }

}
