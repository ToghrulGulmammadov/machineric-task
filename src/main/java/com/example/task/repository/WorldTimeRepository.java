package com.example.task.repository;

import com.example.task.models.WorldTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldTimeRepository extends JpaRepository<WorldTime, Long> {

}
