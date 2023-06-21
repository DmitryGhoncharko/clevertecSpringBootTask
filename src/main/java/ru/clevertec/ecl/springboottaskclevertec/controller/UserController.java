package ru.clevertec.ecl.springboottaskclevertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.ecl.springboottaskclevertec.dto.UserDto;
import ru.clevertec.ecl.springboottaskclevertec.model.User;
import ru.clevertec.ecl.springboottaskclevertec.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.save(userDto), HttpStatus.CREATED);
    }
    @GetMapping(value = "/get/{userName}")
    public ResponseEntity<User> getByUserName(@PathVariable(value = "userName") String name){
        Optional<User> userOptional = userService.findByUserName(name);
        return userOptional.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
