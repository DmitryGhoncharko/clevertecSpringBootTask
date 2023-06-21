package ru.clevertec.ecl.springboottaskclevertec.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.ecl.springboottaskclevertec.dto.OrderDto;
import ru.clevertec.ecl.springboottaskclevertec.model.Order;
import ru.clevertec.ecl.springboottaskclevertec.repository.OrderRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SimpleOrderService implements OrderService {

    private final OrderRepository orderRepository;


    @Override
    public OrderDto save(OrderDto orderDto) {
        Order order = new Order();
        order.setUser(orderDto.getUser());
        order.setPrice(orderDto.getPrice());
        order = orderRepository.save(order);
        orderDto.setId(order.getId());
        return orderDto;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Order> getById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }
}
