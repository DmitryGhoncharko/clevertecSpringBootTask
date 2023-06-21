package ru.clevertec.ecl.springboottaskclevertec.repository;

import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.clevertec.ecl.springboottaskclevertec.model.GiftCertificate;


import javax.sql.DataSource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Testcontainers
@SpringBootTest
@DataJpaTest
class GiftCertificateRepositoryTest {
    @Container
    private static final GenericContainer<?> h2Container = new GenericContainer<>("h2:latest")
            .withExposedPorts(1521);
    @Autowired
    private TestEntityManager testEntityManager;
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
        GiftCertificate giftCertificate = new GiftCertificate();
        giftCertificate.setId(1L);
        giftCertificate.setName("test");
        giftCertificate.setDescription("test");
        giftCertificate.setPrice(22.2);
        giftCertificate.setLastUpdateDate(new Date());
        giftCertificate.setDuration(2);
        giftCertificate.setCreateDate(new Date());
        testEntityManager.persist(giftCertificate);
        List<GiftCertificate> result = giftCertificateRepository.findByNameContains("test");
        Assertions.assertTrue(result.contains(giftCertificate));
    }

    @Test
    void findByNameContainsOrderByNameAsc() {
        List<GiftCertificate> result = giftCertificateRepository.findByNameContainsOrderByNameAsc("test");
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    void findByNameContainsOrderByNameDesc() {
        List<GiftCertificate> result = giftCertificateRepository.findByNameContainsOrderByNameDesc("test");
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    void findByDescriptionContains() {
        List<GiftCertificate> result = giftCertificateRepository.findByDescriptionContains("test");
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    void findByDescriptionContainsOrderByCreateDateAsc() {
        List<GiftCertificate> result = giftCertificateRepository.findByDescriptionContainsOrderByCreateDateAsc("test");
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    void findByDescriptionContainsOrderByCreateDateDesc() {
        List<GiftCertificate> result = giftCertificateRepository.findByDescriptionContainsOrderByCreateDateDesc("test");
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    void findByName() {
        Optional<GiftCertificate> result = giftCertificateRepository.findByName("test");
        Assertions.assertTrue(result.isPresent());
    }

    @TestConfiguration
    static class TestConfig {
        private final DataSource dataSource;

        @Autowired
        public TestConfig(DataSource dataSource) {
            this.dataSource = dataSource;
        }

        @PostConstruct
        public void initialize() {
            if (dataSource instanceof DriverManagerDataSource) {
                DriverManagerDataSource driverManagerDataSource = (DriverManagerDataSource) dataSource;
                String host = h2Container.getContainerIpAddress();
                Integer port = h2Container.getMappedPort(1521);
                String jdbcUrl = "jdbc:h2://" + host + ":" + port + "/test";
                driverManagerDataSource.setUrl(jdbcUrl);
                driverManagerDataSource.setUsername("sa");
                driverManagerDataSource.setPassword("");
            }
        }
    }
}
