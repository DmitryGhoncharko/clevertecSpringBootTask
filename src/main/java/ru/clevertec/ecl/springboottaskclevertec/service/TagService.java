package ru.clevertec.ecl.springboottaskclevertec.service;

import ru.clevertec.ecl.springboottaskclevertec.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    Optional<Tag> findByName(String name);

    List<Tag> findByNameContains(String name);
}
