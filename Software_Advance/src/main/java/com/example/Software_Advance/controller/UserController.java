
package com.example.Software_Advance.controller;
import ch.qos.logback.classic.Logger;
import com.example.Software_Advance.models.Tables.*;
import com.example.Software_Advance.models.Tables.User;
import com.example.Software_Advance.repositories.*;

import com.example.Software_Advance.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private userService userService;
    private  userRepository userRepository;
    private  donorRepository donorRepository;
    Logger log;



   /* public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }*/
   @PostMapping("/create")
   public ResponseEntity<User> createUser(@RequestBody User user) {
       if (user.getDonor() != null) {
           if (!userRepository.existsByEmail(user.getEmail())) {
               Donor donor = user.getDonor();
               donor.setUser(user);
               donorRepository.save(donor);
           } else {
               log.info("User with email {} already exists.", user.getEmail());
           }
       }

      /* if (user.getSponsor() != null) {
           if (!userRepository.existsByEmail(user.getEmail())) {
               Sponsor sponsor = user.getSponsor();
               sponsor.setUser(user);
               sponsorRepository.save(sponsor);
           } else {
               log.info("User with email {} already exists.", user.getEmail());
           }
       }

       if (user.getVolunteer() != null) {
           if (!userRepository.existsByEmail(user.getEmail())) {
               Volunteer volunteer = user.getVolunteer();
               volunteer.setUser(user);
               volunteerRepository.save(volunteer);
           } else {
               log.info("User with email {} already exists.", user.getEmail());
           }
       }

       if (user.getOrganization() != null) {
           if (!userRepository.existsByEmail(user.getEmail())) {
               Organization organization = user.getOrganization();
               organization.setUser(user);
               organizationRepository.save(organization);
           } else {
               log.info("User with email {} already exists.", user.getEmail());
           }
       }

       if (user.getOrphanage() != null) {
           if (!userRepository.existsByEmail(user.getEmail())) {
               Orphanage orphanage = user.getOrphanage();
               orphanage.setUser(user);
               orphanageRepository.save(orphanage);
           } else {
               log.info("User with email {} already exists.", user.getEmail());
           }
       }*/

       // هنا مباشرةً نقوم بحفظ اليوزر في الريبو
       User savedUser = userRepository.save(user);
       return ResponseEntity.ok(savedUser);
   }







    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No users found in the database.");
        }
        return ResponseEntity.ok(users);
    }



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
