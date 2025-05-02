package com.example.Software_Advance.controller;
import ch.qos.logback.classic.Logger;
import com.example.Software_Advance.DTO.CreateUserRequestDTO;
import com.example.Software_Advance.models.Tables.User;

import com.example.Software_Advance.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class userController {
//    private final userRepository userRepository;

    @Autowired
    private userService userService;
    Logger log;


    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequestDTO requestDTO) {
        User savedUser = userService.saveUser(requestDTO);
        return ResponseEntity.ok(savedUser);
    }


    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {

        List<User> users = userService.getAllUsers();
//        if (users.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No users found in the database.");
//        }
        return ResponseEntity.ok(users);
    }


//    @GetMapping("/any")
//    public ResponseEntity<String> any() {
//        return ResponseEntity.ok("hi");
//    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}