package com.project.lunchTime.repository;


import com.project.lunchTime.model.Historic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricRepository extends JpaRepository<Historic, Long> {
}