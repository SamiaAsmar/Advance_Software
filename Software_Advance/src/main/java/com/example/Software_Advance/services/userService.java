package com.example.Software_Advance.services;

import ch.qos.logback.classic.Logger;
import com.example.Software_Advance.models.Tables.User;
import com.example.Software_Advance.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userService {

    Logger log;

    @Autowired
    private userRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            log.warn(">>> User not found with ID: " + id);
            return;
        }
        userRepository.deleteById(id);
        log.info(">>> User with ID {} deleted.", id);
    }
}
