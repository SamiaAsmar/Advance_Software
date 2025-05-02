package com.example.Software_Advance.services;

import com.example.Software_Advance.models.Enums.serviceType;
import com.example.Software_Advance.models.Tables.Organization;
import com.example.Software_Advance.repositories.organizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class organizationService {

    @Autowired
    private organizationRepository organizationRepository;

    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    public Optional<Organization> getOrganizationById(Long id) {
        return organizationRepository.findById(id);
    }

    public List<Organization> getOrganizationsByServiceType(serviceType type) {
        return organizationRepository.findByServiceType(type);
    }

    public Organization saveOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    public void deleteOrganization(Long id) {
        if (organizationRepository.existsById(id)) {
            organizationRepository.deleteById(id);
        }
    }
}
