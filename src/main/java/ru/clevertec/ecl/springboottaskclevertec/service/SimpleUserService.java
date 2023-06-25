package ru.clevertec.ecl.springboottaskclevertec.service;

import com.sun.jdi.request.DuplicateRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.ecl.springboottaskclevertec.dto.UserDto;
import ru.clevertec.ecl.springboottaskclevertec.model.User;
import ru.clevertec.ecl.springboottaskclevertec.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SimpleUserService implements UserService {
    private final UserRepository userRepository;


    @Override
    public UserDto save(UserDto userDto) {
        if (userRepository.findByUserName(userDto.getUserName()).isPresent()) {
            throw new DuplicateRequestException();
        }
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setBalance(userDto.getBalance());
        user = userRepository.save(user);
        userDto.setId(user.getId());
        return userDto;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findByUserName(String name) {
        return userRepository.findByUserName(name);
    }
}
