package ru.clevertec.ecl.springboottaskclevertec.service;

import ru.clevertec.ecl.springboottaskclevertec.model.GiftCertificate;

import java.util.Set;

public interface GiftCertificateService {
    GiftCertificate save(GiftCertificate giftCertificate);

    Set<GiftCertificate> findByNameContains(String name);

    Set<GiftCertificate> findByNameContainsOrderByNameAsc(String name);

    Set<GiftCertificate> findByNameContainsOrderByNameDesc(String name);

    Set<GiftCertificate> findByDescriptionContains(String name);

    Set<GiftCertificate> findByDescriptionContainsOrderByCreateDateAsc(String name);

    Set<GiftCertificate> findByDescriptionContainsOrderByCreateDateDesc(String name);
}
