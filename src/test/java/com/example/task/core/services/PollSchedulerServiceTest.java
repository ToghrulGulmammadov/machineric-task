package com.example.task.core.services;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class PollSchedulerServiceTest {

  @InjectMocks
  private PollSchedulerService service;

  @BeforeEach
  void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void updateScheduler_throwsException_whenIntervalIsEmpty() {
    Assertions.assertThatIllegalStateException().isThrownBy(
        () -> service.updateScheduler(Optional.empty(), System.out::println)
    ).withMessage("Interval is not provided");
  }

  @Test
  void updateScheduler_throwsException_whenIntervalIsNonPositive() {
    Assertions.assertThatIllegalStateException().isThrownBy(
        () -> service.updateScheduler(Optional.of(-1), System.out::println)
    ).withMessage("Interval must be positive number");
  }

}
