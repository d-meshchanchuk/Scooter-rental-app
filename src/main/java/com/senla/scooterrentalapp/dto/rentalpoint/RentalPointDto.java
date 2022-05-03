package com.senla.scooterrentalapp.dto.rentalpoint;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RentalPointDto {
    private Long id;
    private Long parentId;
    private String location;
    private String latitude;
    private String longitude;
}
