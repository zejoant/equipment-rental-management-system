package com.testproject.taskmanager.repository;

import com.testproject.taskmanager.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}