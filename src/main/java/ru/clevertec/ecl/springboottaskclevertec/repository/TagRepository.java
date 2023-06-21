package ru.clevertec.ecl.springboottaskclevertec.repository;

import org.springframework.data.jpa.repository.Query;
import ru.clevertec.ecl.springboottaskclevertec.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag,Long> {
    List<Tag> findByNameContains(String name);
    Optional<Tag> findByName(String name);

    @Query("SELECT t.name, COUNT(*) AS tag_count " +
            "FROM tag  t " +
            "JOIN cert_tag ct ON ct.tag_id = t.id " +
            "JOIN order_t o ON o.gift_id = ct.gift_id " +
            "JOIN user_t u ON u.id = o.user_id " +
            "GROUP BY t.name " +
            "ORDER BY tag_count DESC " +
            "LIMIT 1")
    Tag findMostPopularTag();
}
