package com.example.Software_Advance.controller;

import com.example.Software_Advance.models.Tables.Donor;
import com.example.Software_Advance.models.Tables.Sponsor;
import com.example.Software_Advance.services.sponsorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sponsors")
@RequiredArgsConstructor
public class sponsorController {

    private final sponsorService sponsorService;

    // Get all sponsors
    @GetMapping
    public ResponseEntity<?> getAllSponsors() {
            List<Sponsor> sponsors = sponsorService.getAllSponsors();
            if(sponsors.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No sponsors found in the database.");
            }
            return ResponseEntity.ok(sponsors);

    }

    // Get sponsor by ID
    @GetMapping("{id}")
    public ResponseEntity<?> getSponsorById(@PathVariable Long id) {
        Optional<Sponsor> sponsor = sponsorService.getSponsorById(id);

        if (sponsor.isPresent()) {
            return ResponseEntity.ok(sponsor.get());
        } else {
            return ResponseEntity.ok("No sponsor found with the given ID.");
        }
    }

    // Get sponsor by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<Sponsor> getSponsorByUserId(@PathVariable Long userId) {
        Optional<Sponsor> sponsor = sponsorService.getSponsorByUserId(userId);
        return sponsor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new sponsor
    @PostMapping
    public ResponseEntity<Sponsor> saveSponsor(@Valid @RequestBody Sponsor sponsor) {
        Sponsor savedSponsor = sponsorService.saveSponsor(sponsor);
        return new ResponseEntity<>(savedSponsor, HttpStatus.CREATED);
    }

    // Update sponsor
    @PutMapping("/{id}")
    public ResponseEntity<Sponsor> updateSponsor(@PathVariable Long id, @Valid @RequestBody Sponsor updatedSponsor) {
        try {
            Sponsor updated = sponsorService.updateSponsor(id, updatedSponsor);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    // Delete sponsor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSponsor(@PathVariable Long id) {
        sponsorService.deleteSponsor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
