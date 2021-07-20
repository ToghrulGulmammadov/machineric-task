package com.example.task.core.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class PollSchedulerServiceTest {

  @InjectMocks
  private PollingSchedulerService service;

  @BeforeEach
  void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void updateScheduler_throwsException_whenIntervalIsNonPositive() {
    Assertions.assertThatIllegalStateException().isThrownBy(
        () -> service.updateScheduler(-1, System.out::println)
    ).withMessage("Interval must be positive number");
  }

}
