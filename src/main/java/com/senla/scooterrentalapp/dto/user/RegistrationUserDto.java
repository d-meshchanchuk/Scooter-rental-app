package com.senla.scooterrentalapp.dto.user;

import lombok.Data;

@Data
public class RegistrationUserDto {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
