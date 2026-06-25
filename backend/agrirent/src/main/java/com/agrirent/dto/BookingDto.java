package com.agrirent.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.agrirent.entity.BookingType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {

    private Long machineId;
    
    private BookingType bookingType;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalTime startTime;

    private LocalTime endTime;
}