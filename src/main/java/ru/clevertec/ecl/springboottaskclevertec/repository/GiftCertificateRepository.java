package ru.clevertec.ecl.springboottaskclevertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.ecl.springboottaskclevertec.model.GiftCertificate;

import java.util.List;
import java.util.Set;

public interface GiftCertificateRepository extends JpaRepository<GiftCertificate, Long> {
    List<GiftCertificate> findByNameContains(String name);

    List<GiftCertificate> findByNameContainsOrderByNameAsc(String name);

    List<GiftCertificate> findByNameContainsOrderByNameDesc(String name);

    List<GiftCertificate> findByDescriptionContains(String name);

    List<GiftCertificate> findByDescriptionContainsOrderByCreateDateAsc(String name);

    List<GiftCertificate> findByDescriptionContainsOrderByCreateDateDesc(String name);
}
