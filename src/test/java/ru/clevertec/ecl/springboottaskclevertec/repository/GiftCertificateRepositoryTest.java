package ru.clevertec.ecl.springboottaskclevertec.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import ru.clevertec.ecl.springboottaskclevertec.model.GiftCertificate;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest(properties = {"spring.datasource.url=jdbc:h2:mem:testdb", "spring.datasource.username=sa", "spring.datasource.password=", "spring.jpa.show-sql=true"}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@Sql(scripts = "/initGiftCertificateDB.sql")
class GiftCertificateRepositoryTest {
    @Autowired
    private GiftCertificateRepository giftCertificateRepository;

    @Test
    void save() {
        GiftCertificate giftCertificate = new GiftCertificate();
        giftCertificate.setCreateDate(new Date());
        giftCertificate.setDescription("test1");
        giftCertificate.setDuration(3);
        giftCertificate.setLastUpdateDate(new Date());
        giftCertificate.setName("test123");
        giftCertificate.setPrice(22.2);
        GiftCertificate result = giftCertificateRepository.save(giftCertificate);
        Assertions.assertNotNull(result.getId());
    }

    @Test
    void findByNameContains() {
        List<GiftCertificate> result = giftCertificateRepository.findByNameContains("test");
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    void findByNameContainsOrderByNameAsc() {
        List<GiftCertificate> result = giftCertificateRepository.findByNameContains("test");
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    void findByNameContainsOrderByNameDesc() {
        List<GiftCertificate> result = giftCertificateRepository.findByNameContains("test");
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    void findByDescriptionContains() {
        List<GiftCertificate> result = giftCertificateRepository.findByNameContains("test");
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    void findByDescriptionContainsOrderByCreateDateAsc() {
        List<GiftCertificate> result = giftCertificateRepository.findByNameContains("test");
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    void findByDescriptionContainsOrderByCreateDateDesc() {
        List<GiftCertificate> result = giftCertificateRepository.findByNameContains("test");
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    void findByName() {
        Optional<GiftCertificate> result = giftCertificateRepository.findByName("test");
        Assertions.assertTrue(result.isPresent());
    }
}
