package ru.clevertec.ecl.springboottaskclevertec.service;

import ru.clevertec.ecl.springboottaskclevertec.dto.OrderDto;
import ru.clevertec.ecl.springboottaskclevertec.model.Order;

import java.util.Optional;

public interface OrderService {
    OrderDto save(OrderDto orderDto);

    Optional<Order> getById(Long id);

    Order update(Order order);
}
