package com.example.task.db.models;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Data
@Builder
@Entity(name = "WORLD_TIME")
@AllArgsConstructor
@NoArgsConstructor
public class WorldTimeEntity {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  private String abbreviation;
  private String clientIp;
  private String datetime;
  private int dayOfWeek;
  private int dayOfYear;
  private boolean dst;
  private String dstFrom;
  private int dstOffset;
  private String dstUntil;
  private int rawOffset;
  private String timeZone;
  private int unixTime;
  private String utcDatetime;
  private String utcOffset;
  private int weekNumber;

  @CreatedDate
  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;

}
