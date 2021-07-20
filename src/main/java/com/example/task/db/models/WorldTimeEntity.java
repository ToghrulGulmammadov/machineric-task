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
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

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
  private String client_ip;
  private String datetime;
  private int day_of_week;
  private int day_of_year;
  private boolean dst;
  private String dst_from;
  private int dst_offset;
  private String dst_until;
  private int raw_offset;
  private String timezone;
  private int unixtime;
  private String utc_datetime;
  private String utc_offset;
  private int week_number;

  @CreationTimestamp
  @Column(name = "created_at")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime createdAt;

}
