package ru.clevertec.ecl.springboottaskclevertec.dto;

import lombok.Builder;
import lombok.Data;
import ru.clevertec.ecl.springboottaskclevertec.model.Order;

import java.util.List;

@Data
@Builder
public class UserDto {
    private Long id;
    private String userName;

    private Double balance;

    private List<Order> orders;
}
