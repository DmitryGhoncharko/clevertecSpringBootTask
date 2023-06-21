package ru.clevertec.ecl.springboottaskclevertec.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import ru.clevertec.ecl.springboottaskclevertec.model.User;

import java.util.Optional;

@SpringBootTest(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.show-sql=true"
}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@Sql(scripts = "/initUserDB.sql")
class UserRepositoryTest {
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
}
