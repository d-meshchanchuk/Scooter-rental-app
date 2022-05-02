package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.dto.OrderDto;
import com.senla.scooterrentalapp.dto.user.UserDto;
import com.senla.scooterrentalapp.entity.Order;
import com.senla.scooterrentalapp.mapper.OrderMapper;
import com.senla.scooterrentalapp.mapper.UserMapper;
import com.senla.scooterrentalapp.repository.*;
import com.senla.scooterrentalapp.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final TariffRepository tariffRepository;
    private final UserRepository userRepository;
    private final ScooterRepository scooterRepository;
    private final RentalPointRepository rentalPointRepository;

    @Override
    public OrderDto save(OrderDto orderDto) {
        Order order = Order.builder()
                .id(orderDto.getId())
                .tariff(tariffRepository.getById(orderDto.getTariffId()))
                .user(userRepository.getById(orderDto.getUserId()))
                .scooter(scooterRepository.getById(orderDto.getScooterId()))
                .startPoint(rentalPointRepository.getById(orderDto.getStartPointId()))
                .finishPoint(rentalPointRepository.getById(orderDto.getStartPointId()))
                .created(new Date())
                .closed(orderDto.getClosed())
                .status(orderDto.getStatus())
                .build();

        calculatePrice(order);
        calculateDiscount(order);
        orderRepository.save(order);
        log.info("IN save - order: {} successfully created", order);
        return orderDto;
    }

    @Override
    public void calculatePrice(Order order) {
        Double price = order.getHours() * order.getTariff().getPricePerHour() - order.getUser().getDiscount();
        order.setPrice(price);
    }

    //1 point per order
    @Override
    public void calculateDiscount(Order order) {
        order.getUser().setDiscount(order.getUser().getDiscount()+1);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
        log.info("IN delete - order with id: {} successfully deleted", id);
    }

    @Override
    public List<OrderDto> findAll() {
        List<Order> orders = orderRepository.findAll();
        var result = orders.stream().map(OrderMapper.ORDER_MAPPER::fromOrder).collect(Collectors.toList());
        log.info("IN findAll - {} orders found", result.size());
        return result;
    }

    @Override
    public OrderDto findById(Long id) {
        Order order = orderRepository.findById(id).orElse(null);

        if (order == null) {
            log.warn("IN findById - no order found by id: {}", id);
            return null;
        }

        OrderDto result = OrderMapper.ORDER_MAPPER.fromOrder(order);

        log.info("IN findById - order: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public List<OrderDto> findByUser(UserDto userDto) {
        List<Order> orders = orderRepository.findByUser(UserMapper.USER_MAPPER.toUser(userDto));
        var result = orders.stream().map(OrderMapper.ORDER_MAPPER::fromOrder).collect(Collectors.toList());
        log.info("IN findByUser - {} orders found by user: {}", result, userDto);
        return result;
    }
}
