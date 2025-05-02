package com.example.Software_Advance.services;
import ch.qos.logback.classic.Logger;
import com.example.Software_Advance.models.Enums.Availability;
import com.example.Software_Advance.models.Tables.*;
import com.example.Software_Advance.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class volunteerService {

    Logger log;

    @Autowired
    private volunteerRepository volunteerRepository;

    @Autowired
    private userRepository userRepository;

    @Autowired
    private organizationRepository organizationRepository;

    public Volunteer saveVolunteer(Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }



    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

    public Optional<Volunteer> getVolunteerById(Long id) {
        return volunteerRepository.findById(id);
    }

    public List<Volunteer> getVolunteersByOrganization(Long organizationId) {
        return volunteerRepository.findByOrganizationId(organizationId);
    }

    public List<Volunteer> getVolunteersByStatus(String status) {
        return volunteerRepository.findByStatus(status);
    }

    public List<Volunteer> getVolunteersBySkills(String skills) {
        return volunteerRepository.findBySkillsContaining(skills);
    }

    public List<Volunteer> getVolunteersByAvailability(Availability availability) {
        return volunteerRepository.findByAvailability(availability);
    }

    public void deleteVolunteer(Long id) {
        if (!volunteerRepository.existsById(id)) {
            log.warn(">>> Volunteer not found with ID: " + id);
            return;
        }
        volunteerRepository.deleteById(id);
        log.info(">>> Volunteer with ID {} deleted.", id);
    }
}
