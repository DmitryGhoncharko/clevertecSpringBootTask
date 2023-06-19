package ru.clevertec.ecl.springboottaskclevertec.service;

import ru.clevertec.ecl.springboottaskclevertec.model.Tag;

import java.util.Optional;
import java.util.Set;

public interface TagService {
    Optional<Tag> findByName(String name);

    Set<Tag> findByNameContains(String name);
}
