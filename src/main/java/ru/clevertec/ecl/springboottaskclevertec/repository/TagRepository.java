package ru.clevertec.ecl.springboottaskclevertec.repository;

import ru.clevertec.ecl.springboottaskclevertec.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface TagRepository extends JpaRepository<Tag,Long> {
    Set<Tag> findByNameContains(String name);
    Optional<Tag> findByName(String name);
}
