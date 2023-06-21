package ru.clevertec.ecl.springboottaskclevertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.clevertec.ecl.springboottaskclevertec.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByNameContains(String name);

    Optional<Tag> findByName(String name);

    /**
     * SELECT t.name: The query selects only the tag name. The returned selection will contain only one column.
     * <p>
     * FROM Tag t: The query refers to the Tag table and uses the alias t to refer to this table.
     * <p>
     * JOIN t.giftCertificates gc: The query performs a join (JOIN) between the Tag table and the giftCertificates table on the linking field (foreign key). Use gc alias to refer to giftCertificates table.
     * <p>
     * WHERE gc.id IN (SELECT o.giftCertificate.id ...: The query uses a subquery to select gift certificate id's from the Order table associated with users (JOIN o.user u). The subquery performs a grouping (GROUP BY o.giftCertificate.id) by gift certificate id and sums the cost of orders (SUM(o.price)). The subquery results are then sorted in descending order by the sum of the order costs (ORDER BY SUM(o.price) DESC). It is assumed that the most popular gift certificate will have the highest amount of order value. Finally, the LIMIT 1 statement limits the sample results to only one entry to get the most popular certificate..
     *
     * @return
     */
    @Query("SELECT t.name " +
            "FROM Tag t " +
            "JOIN t.giftCertificates gc " +
            "WHERE gc.id IN (SELECT o.giftCertificate.id " +
            "FROM Order o " +
            "JOIN o.user u " +
            "GROUP BY o.giftCertificate.id " +
            "ORDER BY SUM(o.price) DESC " +
            "LIMIT 1)")
    String findMostPopularTagName();

}
