package com.example.Software_Advance.services;

import ch.qos.logback.classic.Logger;
import com.example.Software_Advance.models.Enums.PaymentType;
import com.example.Software_Advance.models.Enums.SponsorshipType;
import com.example.Software_Advance.models.Enums.UserType;
import com.example.Software_Advance.models.Tables.*;
import com.example.Software_Advance.repositories.*;
import com.example.Software_Advance.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    Logger log;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private SponsorRepository sponsorRepository;

  /*  @Autowired
    private VolunteerRepository volunteerRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private OrphanageRepository orphanageRepository;*/

    public User saveUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            log.warn("User with email {} already exists.", user.getEmail());
            return null;
        }

        User savedUser = userRepository.save(user);
        UserType type = user.getType();

        switch (type) {
            case DONOR:
                Donor donor = new Donor();
                donor.setUser(savedUser);
                donor.setDonationType("DEFAULT");
                donor.setPaymentType(PaymentType.CASH);
                donorRepository.save(donor);
                break;

            case SPONSOR:
                Sponsor sponsor = new Sponsor();
                sponsor.setUser(savedUser);
                    sponsor.setSponsorshipType(SponsorshipType.valueOf("FULL_SPONSORSHIP"));
                    sponsor.setStartDate(LocalDate.now());
                    sponsor.setStatus("ACTIVE");
                sponsorRepository.save(sponsor);
                break;

            default:
                break;
        }

        return savedUser;
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
        //log.info(">>> User with ID {} deleted.", id);
    }
}
