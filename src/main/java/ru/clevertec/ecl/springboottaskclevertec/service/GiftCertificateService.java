package ru.clevertec.ecl.springboottaskclevertec.service;

import ru.clevertec.ecl.springboottaskclevertec.model.GiftCertificate;

import java.util.List;

public interface GiftCertificateService {
    GiftCertificate save(GiftCertificate giftCertificate);

    List<GiftCertificate> findByNameContains(String name);

    List<GiftCertificate> findByNameContainsOrderByNameAsc(String name);

    List<GiftCertificate> findByNameContainsOrderByNameDesc(String name);

    List<GiftCertificate> findByDescriptionContains(String name);

    List<GiftCertificate> findByDescriptionContainsOrderByCreateDateAsc(String name);

    List<GiftCertificate> findByDescriptionContainsOrderByCreateDateDesc(String name);
}
