package com.agrirent.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.agrirent.dto.MachineDto;
import com.agrirent.entity.User;
import com.agrirent.service.MachineService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/machines")
@RequiredArgsConstructor
public class MachineController {

    private final MachineService machineService;

    @PostMapping
    public MachineDto createMachine(
            @RequestBody MachineDto machineDto,
            Authentication authentication) {

        User user = (User) authentication.getPrincipal();

        return machineService.createMachine(
                machineDto,
                user);
    }

    @GetMapping
    public List<MachineDto> getAllMachines() {
        return machineService.getAllMachines();
    }

    @GetMapping("/{id}")
    public MachineDto getMachineById(
            @PathVariable Long id) {

        return machineService.getMachineById(id);
    }

    @PutMapping("/{id}")
    public MachineDto updateMachine(
            @PathVariable Long id,
            @RequestBody MachineDto machineDto) {

        return machineService.updateMachine(
                id,
                machineDto);
    }

    @DeleteMapping("/{id}")
    public String deleteMachine(
            @PathVariable Long id) {

        machineService.deleteMachine(id);

        return "Machine deleted successfully";
    }
}