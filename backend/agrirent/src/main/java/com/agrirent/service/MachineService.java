package com.agrirent.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agrirent.dto.MachineDto;
import com.agrirent.entity.Machine;
import com.agrirent.repository.MachineRepository;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import com.agrirent.entity.User;

@Service
@RequiredArgsConstructor
public class MachineService {

    private final MachineRepository machineRepository;

    public MachineDto createMachine(MachineDto machineDto, User owner) {

        Machine machine = Machine.builder()
                .machineName(machineDto.getMachineName())
                .machineType(machineDto.getMachineType())
                .description(machineDto.getDescription())
                .pricePerDay(machineDto.getPricePerDay())
                .hourlyRentalPrice(machineDto.getHourlyRentalPrice())
                .location(machineDto.getLocation())
                .available(true)
                .owner(owner)
                .build();

        machine = machineRepository.save(machine);

        return MachineDto.builder()
                .machineName(machine.getMachineName())
                .machineType(machine.getMachineType())
                .description(machine.getDescription())
                .pricePerDay(machine.getPricePerDay())
                .hourlyRentalPrice(machine.getHourlyRentalPrice())
                .location(machine.getLocation())
                .build();
    }

    public List<MachineDto> getAllMachines() {
        return machineRepository.findAll()
                .stream()
                .map(machine -> MachineDto.builder()
                        .machineName(machine.getMachineName())
                        .machineType(machine.getMachineType())
                        .description(machine.getDescription())
                        .pricePerDay(machine.getPricePerDay())
                        .hourlyRentalPrice(machine.getHourlyRentalPrice())
                        .location(machine.getLocation())
                        .build())
                .collect(Collectors.toList());
    }

    public MachineDto getMachineById(Long id) {
        return machineRepository.findById(id)
                .map(machine -> MachineDto.builder()
                        .machineName(machine.getMachineName())
                        .machineType(machine.getMachineType())
                        .description(machine.getDescription())
                        .pricePerDay(machine.getPricePerDay())
                        .hourlyRentalPrice(machine.getHourlyRentalPrice())
                        .location(machine.getLocation())
                        .build())
                .orElseThrow(() -> new RuntimeException("Machine not found"));
    }

    public void deleteMachine(Long id) {
        Machine machine = machineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Machine not found"));
        machineRepository.delete(machine);
    }

    public MachineDto updateMachine(Long id, MachineDto machineDto) {
        Machine machine = machineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Machine not found"));
        machine.setMachineName(machineDto.getMachineName());
        machine.setMachineType(machineDto.getMachineType());
        machine.setDescription(machineDto.getDescription());
        machine.setPricePerDay(machineDto.getPricePerDay());
        machine.setHourlyRentalPrice(machineDto.getHourlyRentalPrice());
        machine.setLocation(machineDto.getLocation());
        machine = machineRepository.save(machine);
        return MachineDto.builder()
                .machineName(machine.getMachineName())
                .machineType(machine.getMachineType())
                .description(machine.getDescription())
                .pricePerDay(machine.getPricePerDay())
                .hourlyRentalPrice(machine.getHourlyRentalPrice())
                .location(machine.getLocation())
                .build();
    }

}
