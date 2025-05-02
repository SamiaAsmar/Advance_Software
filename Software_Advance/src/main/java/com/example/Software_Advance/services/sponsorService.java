package com.example.Software_Advance.services;

import com.example.Software_Advance.models.Tables.Sponsor;
import com.example.Software_Advance.repositories.sponsorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class sponsorService {

    private final sponsorRepository sponsorRepository;

    public List<Sponsor> getAllSponsors() {
        return sponsorRepository.findAll();
    }

    public Optional<Sponsor> getSponsorById(Long id) {
        return sponsorRepository.findById(id);
    }

    public Optional<Sponsor> getSponsorByUserId(Long userId) {
        return sponsorRepository.findByUserId(userId);
    }

    public Sponsor saveSponsor(Sponsor sponsor) {
        return sponsorRepository.save(sponsor);
    }

    public Sponsor updateSponsor(Long id, Sponsor updatedSponsor) {
        return sponsorRepository.findById(id)
                .map(existingSponsor -> {
                    existingSponsor.setSponsorshipType(updatedSponsor.getSponsorshipType());
                    existingSponsor.setStartDate(updatedSponsor.getStartDate());
                    existingSponsor.setStatus(updatedSponsor.getStatus());
                    return sponsorRepository.save(existingSponsor);
                })
                .orElseThrow(() -> new RuntimeException("Sponsor not found with id: " + id));
    }

    @Transactional
    public void deleteSponsor(Long id) {
        sponsorRepository.deleteById(id);
    }
}