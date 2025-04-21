package com.example.Software_Advance.services;
import com.example.Software_Advance.DTO.*;
import com.example.Software_Advance.models.Tables.Donor;
import com.example.Software_Advance.repositories.donorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class donorService {

    @Autowired
    private donorRepository donorRepository;


//    public Donor saveDonor(donorDTO donor) {
//        Donor Donor = new Donor();
//
//
//    }


    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    public Optional<Donor> getDonorById(Long id) {
        return donorRepository.findById(id);
    }

    public void deleteDonor(Long id) {
        if (donorRepository.existsById(id)) {
            donorRepository.deleteById(id);
        } else {
            throw new RuntimeException("Donor not found with ID: " + id);
        }
    }


}