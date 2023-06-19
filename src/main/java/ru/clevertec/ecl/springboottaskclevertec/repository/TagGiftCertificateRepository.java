package ru.clevertec.ecl.springboottaskclevertec.repository;

import ru.clevertec.ecl.springboottaskclevertec.model.TagGiftCertificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagGiftCertificateRepository extends JpaRepository<TagGiftCertificate,Long> {
    List<TagGiftCertificate> findAllByTagName(String tagName);


}
