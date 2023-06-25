package ru.clevertec.ecl.springboottaskclevertec.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TagDto {
    private Long id;

    private String name;
}
