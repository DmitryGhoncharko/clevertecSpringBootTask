package ru.clevertec.ecl.springboottaskclevertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.ecl.springboottaskclevertec.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
