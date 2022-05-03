package com.senla.scooterrentalapp.dto;

import com.senla.scooterrentalapp.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private Long tariffId;
    private Integer hours;
    private Double price;
    private Long userId;
    private Long scooterId;
    private Long startPointId;
    private Long finishPointId;
    private LocalDateTime created;
    private LocalDateTime closed;
    private Status status;
}
