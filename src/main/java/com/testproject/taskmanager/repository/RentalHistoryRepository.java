package com.testproject.taskmanager.repository;

import com.testproject.taskmanager.model.RentalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalHistoryRepository extends JpaRepository<RentalHistory, Long> {
}