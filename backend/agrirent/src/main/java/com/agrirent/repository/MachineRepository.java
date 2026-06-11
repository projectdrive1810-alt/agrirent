package com.agrirent.repository;

import com.agrirent.entity.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Long> {

    List<Machine> findByMachineName(String machineName);

    List<Machine> findByMachineType(String machineType);

}
