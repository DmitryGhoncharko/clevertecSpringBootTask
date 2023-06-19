package ru.clevertec.ecl.springboottaskclevertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.ecl.springboottaskclevertec.model.GiftCertificate;

import java.util.Set;

public interface GiftCertificateRepository extends JpaRepository<GiftCertificate, Long> {
    Set<GiftCertificate> findByNameContains(String name);

    Set<GiftCertificate> findByNameContainsOrderByNameAsc(String name);

    Set<GiftCertificate> findByNameContainsOrderByNameDesc(String name);

    Set<GiftCertificate> findByDescriptionContains(String name);

    Set<GiftCertificate> findByDescriptionContainsOrderByCreateDateAsc(String name);

    Set<GiftCertificate> findByDescriptionContainsOrderByCreateDateDesc(String name);
}
