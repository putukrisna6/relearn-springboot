package com.restful.demo.controllers;

import com.restful.demo.models.User;
import com.restful.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping( "")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> postNewUser(@RequestParam String name) {
        User u = new User(name);
        userRepository.save(u);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }
}
