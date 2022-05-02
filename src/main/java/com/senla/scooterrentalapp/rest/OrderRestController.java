package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.dto.OrderDto;
import com.senla.scooterrentalapp.dto.user.UserDto;
import com.senla.scooterrentalapp.exeption.NoContentException;
import com.senla.scooterrentalapp.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/orders/")
public class OrderRestController {

    private final OrderService orderService;

    @GetMapping(value = "{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable(name = "id") Long id) {
        OrderDto result = orderService.findById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "get/{user}")
    public ResponseEntity<List<OrderDto>> OrderByUser(@PathVariable(name = "user") UserDto userDto) throws NoContentException {
        List<OrderDto> result = orderService.findByUser(userDto);

        if (result == null) {
            throw new NoContentException();
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<OrderDto>> getAll() {
        List<OrderDto> result = orderService.findAll();

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody OrderDto orderDto) {
        orderService.save(orderDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        orderService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
