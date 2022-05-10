package com.senla.scooterrentalapp.dto.rentalpoint;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class RentalPointParentDto {
    private Long id;
    private String name;
    private Long parentId;
}
