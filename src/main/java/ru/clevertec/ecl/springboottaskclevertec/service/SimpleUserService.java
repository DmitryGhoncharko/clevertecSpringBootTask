package ru.clevertec.ecl.springboottaskclevertec.service;

import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.clevertec.ecl.springboottaskclevertec.dto.UserDto;
import ru.clevertec.ecl.springboottaskclevertec.model.User;
import ru.clevertec.ecl.springboottaskclevertec.repository.UserRepository;

import java.util.Optional;

@Service
public class SimpleUserService implements UserService{
    private final UserRepository userRepository;
    @Autowired
    public SimpleUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(UserDto userDto) {
        if(userRepository.findByUserName(userDto.getUserName()).isPresent()){
            throw new DuplicateRequestException();
        }
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setBalance(userDto.getBalance());
        user = userRepository.save(user);
        userDto.setId(user.getId());
        return userDto;
    }

    @Override
    public Optional<User> findByUserName(String name) {
        return userRepository.findByUserName(name);
    }
}
