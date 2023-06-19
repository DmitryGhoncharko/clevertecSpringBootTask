package ru.clevertec.ecl.springboottaskclevertec.repository;

import ru.clevertec.ecl.springboottaskclevertec.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag,Long> {
    List<Tag> findByNameContains(String name);
}
