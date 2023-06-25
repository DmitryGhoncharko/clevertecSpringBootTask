package ru.clevertec.ecl.springboottaskclevertec.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.ecl.springboottaskclevertec.dto.OrderDto;
import ru.clevertec.ecl.springboottaskclevertec.model.Order;
import ru.clevertec.ecl.springboottaskclevertec.service.OrderService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;


    @PostMapping(value = "/save")
    public ResponseEntity<OrderDto> save(@RequestBody OrderDto orderDto) {
        return new ResponseEntity<>(orderService.save(orderDto), HttpStatus.CREATED);
    }


    @GetMapping(value = "/get-by-id/{id}")
    public ResponseEntity<Order> getById(@PathVariable(value = "id") Long id) {
        Optional<Order> orderOptional = orderService.getById(id);
        return orderOptional.map(order -> new ResponseEntity<>(order, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PutMapping(value = "/update")
    public ResponseEntity<Order> update(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.update(order), HttpStatus.OK);
    }

}
