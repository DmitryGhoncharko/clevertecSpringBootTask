package ru.clevertec.ecl.springboottaskclevertec.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.clevertec.ecl.springboottaskclevertec.dto.OrderDto;
import ru.clevertec.ecl.springboottaskclevertec.model.Order;
import ru.clevertec.ecl.springboottaskclevertec.model.User;
import ru.clevertec.ecl.springboottaskclevertec.repository.OrderRepository;

import java.util.Optional;

@SpringBootTest
class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @MockBean
    private OrderRepository orderRepository;

    @Test
    void save() {
        User user = new User();
        user.setId(1L);
        user.setUserName("test");
        user.setOrders(null);
        user.setBalance(222.2);
        OrderDto orderDto = OrderDto.builder().user(user).id(1L).price(222.2).timeToBuy(null).giftCertificate(null).build();
        Order order = new Order();
        order.setPrice(222.2);
        order.setUser(user);
        order.setId(1L);
        order.setTimeToBuy(null);
        order.setGiftCertificate(null);
        Mockito.when(orderRepository.save(order)).thenReturn(order);
        OrderDto result = orderService.save(orderDto);
        Assertions.assertEquals(orderDto, result);
    }

    @Test
    void getById() {
        User user = new User();
        user.setId(1L);
        user.setUserName("test");
        user.setOrders(null);
        user.setBalance(222.2);
        Order order = new Order();
        order.setId(1L);
        order.setUser(user);
        order.setPrice(222.2);
        order.setGiftCertificate(null);
        Mockito.when(orderRepository.getById(1L)).thenReturn(order);
        Optional<Order> result = orderService.getById(1L);
        Assertions.assertEquals(result, Optional.of(order));
    }

    @Test
    void update() {
        User user = new User();
        user.setId(1L);
        user.setUserName("test");
        user.setOrders(null);
        user.setBalance(222.2);
        Order order = new Order();
        order.setPrice(222.2);
        order.setUser(user);
        order.setId(1L);
        order.setTimeToBuy(null);
        order.setGiftCertificate(null);
        Mockito.when(orderRepository.save(order)).thenReturn(order);
        Order result = orderService.update(order);
        Assertions.assertEquals(order, result);
    }
}
