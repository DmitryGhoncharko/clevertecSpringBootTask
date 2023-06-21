package ru.clevertec.ecl.springboottaskclevertec.service;

import ru.clevertec.ecl.springboottaskclevertec.dto.GiftCertificateDto;
import ru.clevertec.ecl.springboottaskclevertec.model.GiftCertificate;

import java.util.List;
import java.util.Optional;

public interface GiftCertificateService {
    GiftCertificate save(GiftCertificateDto giftCertificateDto);

    List<GiftCertificate> findByNameContains(String name);

    List<GiftCertificate> findByNameContainsOrderByNameAsc(String name);

    List<GiftCertificate> findByNameContainsOrderByNameDesc(String name);

    List<GiftCertificate> findByDescriptionContains(String name);

    List<GiftCertificate> findByDescriptionContainsOrderByCreateDateAsc(String name);

    List<GiftCertificate> findByDescriptionContainsOrderByCreateDateDesc(String name);

    Optional<GiftCertificate> findByName(String name);

    void remove(GiftCertificate giftCertificate);

    GiftCertificate update(GiftCertificateDto giftCertificateDto);
}
