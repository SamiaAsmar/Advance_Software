/*package com.example.Software_Advance.repositories;

import com.example.Software_Advance.models.Enums.ServiceType;
import com.example.Software_Advance.models.Tables.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface organizationRepository extends JpaRepository<Organization, Long> {

    Optional<Organization> findById(Long id);

    List<Organization> findByServiceType(ServiceType serviceType);

}*/