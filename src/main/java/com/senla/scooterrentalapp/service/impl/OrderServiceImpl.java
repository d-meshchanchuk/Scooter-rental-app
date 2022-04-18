package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.entity.Order;
import com.senla.scooterrentalapp.entity.user.User;
import com.senla.scooterrentalapp.repository.OrderRepository;
import com.senla.scooterrentalapp.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        orderRepository.save(order);
        log.info("IN save - order: {} successfully created", order);
        return order;
    }

    @Override
    public Order update(Order order) {
        //todo update order
        return null;
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
        log.info("IN delete - order with id: {} successfully deleted", id);
    }

    @Override
    public List<Order> findAll() {
        List<Order> result = orderRepository.findAll();
        log.info("IN findAll - {} orders found", result.size());
        return result;
    }

    @Override
    public Order findById(Long id) {
        Order result = orderRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no order found by id: {}", id);
            return null;
        }

        log.info("IN findById - order: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public List<Order> findByUser(User user) {
        List<Order> result = orderRepository.findByUser(user);
        log.info("IN findByUser - {} orders found by user: {}", result, user);
        return result;
    }
}
