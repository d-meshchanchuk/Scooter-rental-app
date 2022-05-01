package com.senla.scooterrentalapp.dto.user;

import com.senla.scooterrentalapp.entity.Status;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Integer discount;
    private Status status;
}
