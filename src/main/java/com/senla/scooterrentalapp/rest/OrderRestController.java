package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.dto.OrderDto;
import com.senla.scooterrentalapp.dto.user.UserDto;
import com.senla.scooterrentalapp.entity.Order;
import com.senla.scooterrentalapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/orders/")
public class OrderRestController {

    private final OrderService orderService;
    private final TariffPricesService tariffPricesService;
    private final ScooterService scooterService;
    private final UserService userService;
    private final RentalPointService rentalPointService;

    @Autowired
    public OrderRestController(OrderService orderService, TariffPricesService tariffPricesService, ScooterService scooterService, UserService userService, RentalPointService rentalPointService) {
        this.orderService = orderService;
        this.tariffPricesService = tariffPricesService;
        this.scooterService = scooterService;
        this.userService = userService;
        this.rentalPointService = rentalPointService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable(name = "id") Long id) {
        Order order = orderService.findById(id);

        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        OrderDto result = OrderDto.fromOrder(order);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "get/{user}")
    public ResponseEntity<List<OrderDto>> getScootersInfoByScooter(@PathVariable(name = "user") UserDto userDto) {
        List<Order> orders = orderService.findByUser(userDto.toUser());

        if (orders == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<OrderDto> result = new ArrayList<>();
        orders.forEach(order -> result.add(OrderDto.fromOrder(order)));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<OrderDto>> getAll() {
        List<Order> orders = orderService.findAll();

        if (orders == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<OrderDto> result = new ArrayList<>();
        orders.forEach(order -> result.add(OrderDto.fromOrder(order)));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody OrderDto orderDto) {
        Order order = new Order();
        order.setTariffPrices(tariffPricesService.findById(orderDto.getTariffPricesId()));
        order.setHours(orderDto.getHours());
        order.setPrice(orderDto.getPrice());
        order.setUser(userService.findById(orderDto.getUserId()));
        order.setScooter(scooterService.findById(orderDto.getScooterId()));
        order.setStartPoint(rentalPointService.findById(orderDto.getStartPointId()));
        order.setFinishPoint(rentalPointService.findById(orderDto.getFinishPointId()));
        order.setCreated(new Date());
        order.setStatus(orderDto.getStatus());

        orderService.save(order);
        return new ResponseEntity<>(HttpStatus.OK);
        //todo какую ошибку отловить?
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        orderService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
