package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.dto.OrderDto;
import com.senla.scooterrentalapp.dto.rentalpoint.RentalPointDto;
import com.senla.scooterrentalapp.dto.scooter.ScootersInfoDto;
import com.senla.scooterrentalapp.entity.Order;
import com.senla.scooterrentalapp.entity.Status;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPointParent;
import com.senla.scooterrentalapp.entity.scooter.Scooter;
import com.senla.scooterrentalapp.entity.tariff.Tariff;
import com.senla.scooterrentalapp.entity.user.User;
import com.senla.scooterrentalapp.mapper.OrderMapper;
import com.senla.scooterrentalapp.mapper.OrderMapperImpl;
import com.senla.scooterrentalapp.mapper.ScooterMapper;
import com.senla.scooterrentalapp.mapper.ScooterMapperImpl;
import com.senla.scooterrentalapp.repository.OrderRepository;
import com.senla.scooterrentalapp.repository.ScooterRepository;
import com.senla.scooterrentalapp.repository.UserRepository;
import com.senla.scooterrentalapp.service.OrderService;
import com.senla.scooterrentalapp.service.ScooterService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    OrderRepository repository = Mockito.mock(OrderRepository.class);
    UserRepository userRepository = Mockito.mock(UserRepository.class);
    OrderMapper orderMapper = new OrderMapperImpl();
    OrderService service = new OrderServiceImpl(repository, userRepository, orderMapper);

    Scooter scooter = Scooter.builder()
            .id(1L)
            .model("test")
            .power(100)
            .build();

    RentalPointParent rentalPointParent = RentalPointParent.builder()
            .id(1L)
            .name("Test")
            .build();

    RentalPoint rentalPoint = RentalPoint.builder()
            .id(1L)
            .parent(rentalPointParent)
            .build();

    User user = User.builder()
            .id(1L)
            .username("test")
            .email("test@mail.com")
            .discount(10)
            .status(Status.ACTIVE)
            .build();

    Tariff tariff = Tariff.builder()
            .id(1L)
            .hours(1)
            .pricePerHour(1.5)
            .build();

    List<Order> orders = new ArrayList<>();

    Order order = Order.builder()
            .id(1L)
            .tariff(tariff)
            .hours(10)
            .user(user)
            .scooter(scooter)
            .startPoint(rentalPoint)
            .finishPoint(rentalPoint)
            .created(LocalDateTime.now())
            .status(Status.ACTIVE)
            .build();

    @Test
    void save() {
        OrderDto result = service.save(orderMapper.fromOrder(order));
        service.calculatePrice(order);
        Mockito.verify(repository).save(order);
        assertEquals(orderMapper.toOrder(result), order);
    }

    @Test
    void findAll() {
        Mockito.when(repository.findAll()).thenReturn(orders);
        List<OrderDto> orderDtoList = service.findAll();
        Mockito.verify(repository, Mockito.times(1)).findAll();
        assertEquals(orders, orderDtoList.stream().map(orderMapper::toOrder).collect(Collectors.toList()));
    }

    @Test
    @SneakyThrows
    void findById() {
        Long id = order.getId();
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(order));
        OrderDto result = service.findById(id);
        Mockito.verify(repository, Mockito.times(1)).findById(id);
        assertEquals(orderMapper.toOrder(result), order);
    }

    @Test
    void findByUser() {
        Long id = user.getId();
        orders.add(order);
        Mockito.when(repository.findByUser(user)).thenReturn(orders);
        Mockito.when(userRepository.getById(id)).thenReturn(user);
        List<OrderDto> result = service.findByUserId(id);
        System.out.println(result);
        Mockito.verify(repository, Mockito.times(1)).findByUser(user);
        assertEquals(orders.stream().map(orderMapper::fromOrder).collect(Collectors.toList()), result);
    }
}