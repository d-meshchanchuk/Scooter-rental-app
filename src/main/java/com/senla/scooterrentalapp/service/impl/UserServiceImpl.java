package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.entity.Status;
import com.senla.scooterrentalapp.entity.user.Role;
import com.senla.scooterrentalapp.entity.user.User;
import com.senla.scooterrentalapp.exception.NoContentException;
import com.senla.scooterrentalapp.repository.RoleRepository;
import com.senla.scooterrentalapp.repository.UserRepository;
import com.senla.scooterrentalapp.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setDiscount(0);
        user.setStatus(Status.ACTIVE);

        User registeredUser = userRepository.save(user);

        log.info("IN register - user: {} successfully registered", registeredUser);

        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        log.info("IN getAll - {} users found", result.size());
        return result;
    }

    @Override
    public User findByUsername(String username) throws UsernameNotFoundException {
        User result = userRepository.findByUsername(username);

        if (result == null) {
            log.warn("IN findByUserName - no user found by username: {}", username);
            throw new UsernameNotFoundException("username " + username + " not found");
        }

        log.info("IN findByUsername - user: {} found by username: {}", result, username);
        return result;
    }

    @Override
    public User findById(Long id) throws NoContentException {
        User result = userRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no user found by id: {}", id);
            throw new NoContentException();
        }

        log.info("IN findById - user: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public User save(User user) {
        User registeredUser = userRepository.save(user);
        log.info("IN save - tariff: {} successfully created", registeredUser);
        return registeredUser;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully deleted", id);
    }

}
