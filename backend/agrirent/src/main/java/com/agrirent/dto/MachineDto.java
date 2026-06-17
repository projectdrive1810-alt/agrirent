package com.agrirent.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MachineDto {

    private String machineName;

    private String machineType;

    private String description;

    private BigDecimal pricePerDay;

    private BigDecimal hourlyRentalPrice;

    private String location;

}
