package com.senla.scooterrentalapp.dto.rentalpoint;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class rentalPointDto {
    private Long id;
    private Long parentId;
    private String location;
    private String latitude;
    private String longitude;
}
