package ru.clevertec.ecl.springboottaskclevertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.ecl.springboottaskclevertec.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String name);
}
