package ru.clevertec.ecl.springboottaskclevertec.service;

import ru.clevertec.ecl.springboottaskclevertec.dto.UserDto;
import ru.clevertec.ecl.springboottaskclevertec.model.User;

import java.util.Optional;

public interface UserService {
    UserDto save(UserDto userDto);

    Optional<User> findByUserName(String name);

}
