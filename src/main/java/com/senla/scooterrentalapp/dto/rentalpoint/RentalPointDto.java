package com.senla.scooterrentalapp.dto.rentalpoint;

import lombok.Data;

@Data
public class RentalPointDto {
    private Long id;
    private RentalPointParentDto parent;
    private String location;
    private String latitude;
    private String longitude;
}
