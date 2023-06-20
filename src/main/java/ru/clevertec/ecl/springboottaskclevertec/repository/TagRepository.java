package ru.clevertec.ecl.springboottaskclevertec.repository;

import ru.clevertec.ecl.springboottaskclevertec.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag,Long> {
    List<Tag> findByNameContains(String name);
    Optional<Tag> findByName(String name);
}
