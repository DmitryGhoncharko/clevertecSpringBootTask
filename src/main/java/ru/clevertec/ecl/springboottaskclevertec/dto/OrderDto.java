package ru.clevertec.ecl.springboottaskclevertec.dto;

import lombok.Builder;
import lombok.Data;
import ru.clevertec.ecl.springboottaskclevertec.model.GiftCertificate;
import ru.clevertec.ecl.springboottaskclevertec.model.User;

import java.util.Date;

@Data
@Builder
public class OrderDto {
    private Long id;

    private User user;

    private GiftCertificate giftCertificate;
    private Date timeToBuy;
    private double price;
}
