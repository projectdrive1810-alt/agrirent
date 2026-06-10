package com.agrirent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agrirent.entity.MachineImage;

@Repository
public interface MachineImageRepository extends JpaRepository<MachineImage, Long> {

}
