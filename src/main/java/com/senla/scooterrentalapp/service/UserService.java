package com.senla.scooterrentalapp.service;

import com.senla.scooterrentalapp.entity.user.User;
import com.senla.scooterrentalapp.exception.NoContentException;

import java.util.List;

public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id) throws NoContentException;

    User save(User user);

    void delete(Long id);
}
