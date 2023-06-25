package ru.clevertec.ecl.springboottaskclevertec.service;

import ru.clevertec.ecl.springboottaskclevertec.dto.TagDto;

import java.util.List;
import java.util.Optional;

public interface TagService {
    Optional<TagDto> findByName(String name);

    List<TagDto> findByNameContains(String name);

    TagDto save(TagDto tagDto);

    void remove(TagDto tagDto);

    TagDto update(TagDto tagDto);

    String findMostPopularTag();
}
