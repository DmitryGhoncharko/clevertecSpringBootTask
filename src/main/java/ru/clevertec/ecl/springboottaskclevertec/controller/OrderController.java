package ru.clevertec.ecl.springboottaskclevertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.ecl.springboottaskclevertec.dto.OrderDto;
import ru.clevertec.ecl.springboottaskclevertec.model.Order;
import ru.clevertec.ecl.springboottaskclevertec.repository.OrderRepository;
import ru.clevertec.ecl.springboottaskclevertec.service.OrderService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<OrderDto> save(@RequestBody OrderDto orderDto){
        return new ResponseEntity<>(orderService.save(orderDto), HttpStatus.CREATED);
    }
    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<Order> getById(@PathVariable(value = "id") Long id){
        Optional<Order> orderOptional = orderService.getById(id);
        return orderOptional.map(order -> new ResponseEntity<>(order, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping(value = "/update")
    public ResponseEntity<Order> update(@RequestBody Order order){
        return new ResponseEntity<>(orderService.update(order),HttpStatus.OK);
    }
}
