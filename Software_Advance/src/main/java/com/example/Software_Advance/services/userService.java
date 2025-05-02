package com.example.Software_Advance.services;

import ch.qos.logback.classic.Logger;
import com.example.Software_Advance.DTO.*;
import com.example.Software_Advance.models.Tables.*;
import com.example.Software_Advance.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class userService {

    Logger log;

    @Autowired
    private userRepository userRepository;

    @Autowired
    private donorRepository donorRepository;

    @Autowired
    private sponsorRepository sponsorRepository;

   @Autowired
    private volunteerRepository volunteerRepository;

    @Autowired
    private organizationRepository organizationRepository;

    @Autowired
    private orphanageRepository orphanageRepository;



    public User saveUser(CreateUserRequestDTO requestDTO) {
        userDTO userDTO = requestDTO.getUser();

        if (userRepository.existsByEmail(userDTO.getEmail())) {
            log.warn("User with email {} already exists.", userDTO.getEmail());
            return null;
        }

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        user.setAddress(userDTO.getAddress());
        user.setType(userDTO.getType());
        user.setRole(userDTO.getRole());

        User savedUser = userRepository.save(user);

        switch (userDTO.getType()) {
            case DONOR -> {
                donorDTO donorDTO = requestDTO.getDonor();
                if (donorDTO == null || donorDTO.getDonations() == null || donorDTO.getDonations().isEmpty()) {
                    throw new IllegalArgumentException("Donor must have at least one donation");
                }

                Donor donor = new Donor();
                donor.setUser(savedUser);

                List<Donation> donationList = donorDTO.getDonations().stream().map(donationDTO -> {
                    Donation donation = new Donation();
                    donation.setDonationType(donationDTO.getDonationType());
                    donation.setPaymentType(donationDTO.getPaymentType());
                    donation.setDonationAmount(donationDTO.getDonationAmount());
                    donation.setOrganizationId(donationDTO.getOrganizationId());
                    donation.setDonor(donor);
                    return donation;
                }).toList();

                donor.setDonations(donationList);
                savedUser.setDonor(donor);
                donorRepository.save(donor);
            }

           case SPONSOR -> {
                sponsorDTO sponsorDTO = requestDTO.getSponsor();
                Sponsor sponsor = new Sponsor();
                sponsor.setUser(savedUser);
                sponsor.setSponsorshipType(sponsorDTO.getSponsorshipType());
                sponsor.setStartDate(sponsorDTO.getStartDate());
                sponsor.setStatus(sponsorDTO.getStatus());

               savedUser.setSponsor(sponsor);
               sponsorRepository.save(sponsor);
            }

            case VOLUNTEER -> {
                volunteerDTO volunteerDTO = requestDTO.getVolunteer();
                Volunteer volunteer = new Volunteer();
                volunteer.setUser(savedUser);
                volunteer.setOrganizationId(volunteerDTO.getOrganizationId());
                volunteer.setSkills(volunteerDTO.getSkills());
                volunteer.setAvailability(volunteerDTO.getAvailability());
                volunteer.setStatus(volunteerDTO.getStatus());
                volunteerRepository.save(volunteer);
            }

          /*  case ORGANIZATION -> {
                organizationDTO organizationDTO = requestDTO.getOrganization();
                Organization organization = new Organization();
                organization.setUser(savedUser);
                organization.setServiceType(organizationDTO.getServiceType());
                organizationRepository.save(organization);
            }*/

           /* case ORPHANAGE -> {
                orphanageDTO orphanageDTO = requestDTO.getOrphanage();
                Orphanage orphanage = new Orphanage();
                orphanage.setUser(savedUser);
                orphanage.setCapacity(orphanageDTO.getCapacity());
                orphanage.setOrphanCount(orphanageDTO.getOrphanCount());
                orphanage.setVerified(orphanageDTO.isVerified());
                orphanageRepository.save(orphanage);
            }*/

            default -> log.warn("Unknown user type: {}", userDTO.getType());
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