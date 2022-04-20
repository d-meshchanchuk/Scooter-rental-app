package com.senla.scooterrentalapp.dto;

import com.senla.scooterrentalapp.entity.Order;
import com.senla.scooterrentalapp.entity.Status;
import lombok.Data;

import java.util.Date;

@Data
public class OrderDto {
    private Long id;
    private Long tariffId;
    private Integer hours;
    private Double price;
    private Long userId;
    private Long scooterId;
    private Long startPointId;
    private Long finishPointId;
    private Date created;
    private Date closed;
    private Status status;

    public static OrderDto fromOrder(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setTariffId(order.getTariff().getId());
        orderDto.setHours(order.getHours());
        orderDto.setPrice(order.getPrice());
        orderDto.setScooterId(order.getScooter().getId());
        orderDto.setStartPointId(order.getStartPoint().getId());
        orderDto.setFinishPointId(order.getFinishPoint().getId());
        orderDto.setCreated(order.getCreated());
        orderDto.setClosed(order.getClosed());
        orderDto.setStatus(order.getStatus());

        return orderDto;
    }
}
