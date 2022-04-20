package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.dto.OrderDto;
import com.senla.scooterrentalapp.dto.user.UserDto;
import com.senla.scooterrentalapp.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/orders/")
public class OrderRestController {

    private final OrderService orderService;

    @GetMapping(value = "{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable(name = "id") Long id) {
        OrderDto result = orderService.findById(id);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "get/{user}")
    public ResponseEntity<List<OrderDto>> getScootersInfoByScooter(@PathVariable(name = "user") UserDto userDto) {
        List<OrderDto> result = orderService.findByUser(userDto);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping()
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
