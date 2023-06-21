package ru.clevertec.ecl.springboottaskclevertec.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.clevertec.ecl.springboottaskclevertec.dto.UserDto;
import ru.clevertec.ecl.springboottaskclevertec.model.User;
import ru.clevertec.ecl.springboottaskclevertec.repository.UserRepository;

import java.util.Optional;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;

    @Test
    void save() {
        UserDto userDto = UserDto.builder().userName("test").balance(22.2).build();
        User user = new User();
        user.setUserName("test");
        user.setBalance(22.2);
        User expectedUser = new User();
        expectedUser.setUserName("test");
        expectedUser.setBalance(22.2);
        expectedUser.setId(1L);
        Mockito.when(userRepository.save(user)).thenReturn(expectedUser);
        UserDto result = userService.save(userDto);
        userDto.setId(1L);
        Assertions.assertEquals(result, userDto);
    }

    @Test
    void findByUserName() {
        User user = new User();
        user.setUserName("test");
        user.setBalance(22.2);
        Mockito.when(userRepository.findByUserName("test")).thenReturn(Optional.of(user));
        Optional<User> result = userService.findByUserName("test");
        Assertions.assertEquals(result, Optional.of(user));
    }
}
