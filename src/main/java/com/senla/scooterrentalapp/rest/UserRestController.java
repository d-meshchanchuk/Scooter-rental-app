package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.dto.user.UserDto;
import com.senla.scooterrentalapp.entity.user.User;
import com.senla.scooterrentalapp.mapper.UserMapper;
import com.senla.scooterrentalapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/users/")
public class UserRestController {

    private final UserService userService;

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id) {
        User result = userService.findById(id);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(UserMapper.USER_MAPPER.UserDtoFromUser(result), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAll() {
        List<User> users = userService.getAll();

        if (users == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(users.stream().map(UserMapper.USER_MAPPER::UserDtoFromUser).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody UserDto userDto) {
        userService.save(UserMapper.USER_MAPPER.toUser(userDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
