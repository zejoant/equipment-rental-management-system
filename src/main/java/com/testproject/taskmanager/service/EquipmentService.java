package com.testproject.taskmanager.service;

import com.testproject.taskmanager.model.Equipment;
import com.testproject.taskmanager.model.RentalHistory;
import com.testproject.taskmanager.repository.EquipmentRepository;
import com.testproject.taskmanager.repository.RentalHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepository repo;
    private final RentalHistoryRepository historyRepo;

    public EquipmentService(EquipmentRepository repo,
                            RentalHistoryRepository historyRepo) {
        this.repo = repo;
        this.historyRepo = historyRepo;
    }

    // GET all equipment
    public List<Equipment> getAll() {
        return repo.findAll();
    }

    // GET one equipment
    public Equipment getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));
    }

    // CREATE equipment
    public Equipment add(Equipment equipment) {
        equipment.setStatus("AVAILABLE");
        return repo.save(equipment);
    }

    // CHECKOUT equipment
    public Equipment checkout(Long id) {
        Equipment eq = getById(id);

        if (!eq.getStatus().equals("AVAILABLE")) {
            throw new RuntimeException("Equipment already checked out");
        }

        eq.setStatus("CHECKED_OUT");

        repo.save(eq);

        historyRepo.save(new RentalHistory(
                null,
                eq.getId(),
                "CHECKOUT",
                LocalDateTime.now()
        ));

        return eq;
    }

    // CHECKIN equipment
    public Equipment checkin(Long id) {
        Equipment eq = getById(id);

        if (eq.getStatus().equals("AVAILABLE")) {
            throw new RuntimeException("Equipment is already available");
        }

        eq.setStatus("AVAILABLE");

        repo.save(eq);

        historyRepo.save(new RentalHistory(
                null,
                eq.getId(),
                "CHECKIN",
                LocalDateTime.now()
        ));

        return eq;
    }
}