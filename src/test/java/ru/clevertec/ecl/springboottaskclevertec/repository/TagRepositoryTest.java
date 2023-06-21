package ru.clevertec.ecl.springboottaskclevertec.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.clevertec.ecl.springboottaskclevertec.model.Tag;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Testcontainers
@SpringBootTest
@DataJpaTest
class TagRepositoryTest {
    @Container
    private static final GenericContainer<?> h2Container = new GenericContainer<>("h2:latest")
            .withExposedPorts(1521);
    @Autowired
    private TagRepository tagRepository;

    @Test
    void findByNameContains() {
        List<Tag> tags = tagRepository.findByNameContains("te");
        Assertions.assertTrue(tags.size() > 0);
    }

    @Test
    void findByName() {
        Optional<Tag> tag = tagRepository.findByName("test");
        Assertions.assertTrue(tag.isPresent());
    }

    @Test
    void save() {
        Tag tag = new Tag();
        tag.setName("test111");
        Tag result = tagRepository.save(tag);
        Assertions.assertNotNull(result.getId());
    }

    @Test
    void update() {
        Optional<Tag> tag = tagRepository.findByName("test");
        if (tag.isPresent()) {
            Tag tag1 = tag.get();
            tag1.setName("test678");
            Tag result = tagRepository.save(tag1);
            Assertions.assertEquals(result, tag1);
        }
        Assertions.fail();
    }

    @TestConfiguration
    @Import(ContainerConfig.class)
    static class TestConfig {
        @Autowired
        private DataSource dataSource;

        @Bean
        public DataSource dataSource() {
            if (dataSource instanceof DriverManagerDataSource driverManagerDataSource) {
                String host = h2Container.getContainerIpAddress();
                Integer port = h2Container.getMappedPort(1521);
                String jdbcUrl = "jdbc:h2://" + host + ":" + port + "/test";
                driverManagerDataSource.setUrl(jdbcUrl);
                driverManagerDataSource.setUsername("sa");
                driverManagerDataSource.setPassword("");
            }
            return dataSource;
        }
    }

    @Configuration
    static class ContainerConfig {
        @Bean
        public GenericContainer<?> h2Container() {
            return new GenericContainer<>("h2:latest").withExposedPorts(1521);
        }
    }
}
