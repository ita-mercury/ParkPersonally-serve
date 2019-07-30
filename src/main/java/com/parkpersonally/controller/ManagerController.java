package com.parkpersonally.controller;

import com.parkpersonally.model.Manager;
import com.parkpersonally.model.ParkingBoy;
import com.parkpersonally.model.ParkingLot;
import com.parkpersonally.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/managers/{managerId}/parking-lots")
    public ResponseEntity<List<ParkingLot>> getAllParkingLotOnManeger(@PathVariable long managerId){
        return ResponseEntity.ok(managerService.getAllParkingLotOnManager(managerId));
    }
    @GetMapping("/managers/{managerId}/parking-boys")
    public ResponseEntity<List<ParkingBoy>> getAllParkingBoys(@PathVariable long managerId){
        return ResponseEntity.ok(managerService.getParkingBoys(managerId));
    }
    @PostMapping("/managers")
    public ResponseEntity<Manager> createManager(@RequestBody Manager manager){
        return ResponseEntity.ok(managerService.saveManager(manager));
    }
}
