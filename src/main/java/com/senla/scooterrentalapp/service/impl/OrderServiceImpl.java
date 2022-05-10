package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.dto.OrderDto;
import com.senla.scooterrentalapp.dto.user.UserDto;
import com.senla.scooterrentalapp.entity.Order;
import com.senla.scooterrentalapp.entity.user.User;
import com.senla.scooterrentalapp.mapper.OrderMapper;
import com.senla.scooterrentalapp.mapper.UserMapper;
import com.senla.scooterrentalapp.repository.*;
import com.senla.scooterrentalapp.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderDto save(OrderDto orderDto) {
        Order order = orderMapper.toOrder(orderDto);

        calculatePrice(order);
        orderRepository.save(order);
        log.info("IN save - order: {} successfully created", order);
        return orderDto;
    }

    @Override
    public void calculatePrice(Order order) {
        Double price = order.getHours() * order.getTariff().getPricePerHour();
        Double discount = price * order.getUser().getDiscount() / 100;
        Double discountPrice = price - discount;
        order.setPrice(discountPrice);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
        log.info("IN delete - order with id: {} successfully deleted", id);
    }

    @Override
    public List<OrderDto> findAll() {
        List<Order> orders = orderRepository.findAll();
        var result = orders.stream().map(orderMapper::fromOrder).collect(Collectors.toList());
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

        OrderDto result = orderMapper.fromOrder(order);

        log.info("IN findById - order: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public List<OrderDto> findByUserId(Long userId) {
        User user = userRepository.getById(userId);
        List<Order> orders = orderRepository.findByUser(user);
        var result = orders.stream().map(orderMapper::fromOrder).collect(Collectors.toList());
        log.info("IN findByUser - {} orders found by user: {}", result, user);
        return result;
    }
}
