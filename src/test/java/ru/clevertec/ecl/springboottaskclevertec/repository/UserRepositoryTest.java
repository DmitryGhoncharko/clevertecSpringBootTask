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
import ru.clevertec.ecl.springboottaskclevertec.model.User;

import javax.sql.DataSource;
import java.util.Optional;

@Testcontainers
@SpringBootTest
@DataJpaTest
class UserRepositoryTest {
    @Container
    private static final GenericContainer<?> h2Container = new GenericContainer<>("h2:latest")
            .withExposedPorts(1521);
    @Autowired
    private UserRepository userRepository;

    @Test
    void save() {
        User user = new User();
        user.setUserName("test1");
        user.setBalance(22.2);
        User result = userRepository.save(user);
        Assertions.assertNotNull(result.getId());
    }

    @Test
    void findByUserName() {
        Optional<User> result = userRepository.findByUserName("test");
        Assertions.assertTrue(result.isPresent());
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
