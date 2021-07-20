package com.example.task.db.repository;

import com.example.task.db.models.WorldTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldTimeRepository extends JpaRepository<WorldTimeEntity, Long> {

}
