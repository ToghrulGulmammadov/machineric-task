package com.example.task.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "WORLD_TIME")
@AllArgsConstructor
@NoArgsConstructor
public class WorldTime {

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

}
