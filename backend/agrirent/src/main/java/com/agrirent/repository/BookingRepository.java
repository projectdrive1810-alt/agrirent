package com.agrirent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agrirent.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}