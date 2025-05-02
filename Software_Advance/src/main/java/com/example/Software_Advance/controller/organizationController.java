package com.example.Software_Advance.controller;

import com.example.Software_Advance.models.Enums.serviceType;
import com.example.Software_Advance.models.Tables.Organization;
import com.example.Software_Advance.services.organizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/organizations")
public class organizationController {

    @Autowired
    private organizationService organizationService;
    @Autowired
    private com.example.Software_Advance.repositories.organizationRepository organizationRepository;


//    @GetMapping
//    public ResponseEntity<List<Organization>> getAllOrganizations() {
//        return ResponseEntity.ok(organizationService.getAllOrganizations());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getOrganizationById(@PathVariable Long id) {
//        Optional<Organization> org = organizationService.getOrganizationById(id);
//        if (org.isPresent()) {
//            return ResponseEntity.ok(org.get());
//        } else {
//            String errorMessage = "Organization not found with ID: " + id;
//            return ResponseEntity.status(404).body(errorMessage);
//        }
//    }


    @GetMapping("/service-type/{type}")
    public ResponseEntity<List<Organization>> getByServiceType(@PathVariable serviceType type) {
        return ResponseEntity.ok(organizationService.getOrganizationsByServiceType(type));
    }

    @PutMapping("/{id}/service-type")
    public ResponseEntity<String> updateServiceType(@PathVariable Long id, @RequestBody Map<String, String> body) {
        Optional<Organization> optional = organizationRepository.findById(id);

        if (optional.isEmpty()) {
            return ResponseEntity.status(404).body("Organization not found with ID: " + id);
        }

        Organization org = optional.get();
        String typeStr = body.get("serviceType");

        try {
            serviceType serviceTypeEnum = serviceType.valueOf(typeStr.toUpperCase().trim());
            org.setServiceType(serviceTypeEnum);
            organizationRepository.save(org);
            return ResponseEntity.ok("Service type updated successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid service type value.");
        }
    }





}
