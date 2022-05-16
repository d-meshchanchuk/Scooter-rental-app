package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.dto.user.RegistrationUserDto;
import com.senla.scooterrentalapp.mapper.UserMapper;
import com.senla.scooterrentalapp.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/registration")
public class RegistrationRestController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<Void> registration(@RequestBody RegistrationUserDto registrationUserDto) {
        userService.register(userMapper.toUser(registrationUserDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
