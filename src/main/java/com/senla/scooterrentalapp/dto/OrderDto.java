package com.senla.scooterrentalapp.dto;

import com.senla.scooterrentalapp.dto.rentalpoint.RentalPointDto;
import com.senla.scooterrentalapp.dto.scooter.ScooterDto;
import com.senla.scooterrentalapp.dto.tariff.TariffDto;
import com.senla.scooterrentalapp.dto.user.UserDto;
import com.senla.scooterrentalapp.entity.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDto {
    private Long id;
    private TariffDto tariff;
    private Integer hours;
    private Double price;
    private UserDto user;
    private ScooterDto scooter;
    private RentalPointDto startPoint;
    private RentalPointDto finishPoint;
    private LocalDateTime created;
    private LocalDateTime closed;
    private Status status;
}
