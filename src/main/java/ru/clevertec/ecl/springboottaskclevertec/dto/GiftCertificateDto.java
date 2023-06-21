package ru.clevertec.ecl.springboottaskclevertec.dto;

import lombok.Builder;
import lombok.Data;
import ru.clevertec.ecl.springboottaskclevertec.model.Tag;

import java.util.List;

@Data
@Builder
public class GiftCertificateDto {
    private Long id;

    private String name;

    private String description;

    private Integer duration;

    private Double price;

    private List<Tag> tags;
}
