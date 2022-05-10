package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.dto.user.UserDto;
import com.senla.scooterrentalapp.entity.user.User;
import com.senla.scooterrentalapp.exception.NoContentException;
import com.senla.scooterrentalapp.mapper.UserMapper;
import com.senla.scooterrentalapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/users/")
public class UserRestController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping(value = "{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id) throws NoContentException {
        User result = userService.findById(id);
        return new ResponseEntity<>(userMapper.UserDtoFromUser(result), HttpStatus.OK);
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<UserDto>> getAll() {
        List<User> users = userService.getAll();
        return new ResponseEntity<>(users.stream().map(userMapper::UserDtoFromUser).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody UserDto userDto) {
        userService.save(userMapper.toUser(userDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
