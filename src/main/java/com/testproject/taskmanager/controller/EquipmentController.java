package com.testproject.taskmanager.controller;

import com.testproject.taskmanager.model.Equipment;
import com.testproject.taskmanager.service.EquipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    private final EquipmentService service;

    public EquipmentController(EquipmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Equipment> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Equipment getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Equipment add(@RequestBody Equipment equipment) {
        return service.add(equipment);
    }

    @PostMapping("/{id}/checkout")
    public Equipment checkout(@PathVariable Long id) {
        return service.checkout(id);
    }

    @PostMapping("/{id}/checkin")
    public Equipment checkin(@PathVariable Long id) {
        return service.checkin(id);
    }
}