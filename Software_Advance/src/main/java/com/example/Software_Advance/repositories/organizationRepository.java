package com.example.Software_Advance.repositories;

import com.example.Software_Advance.models.Enums.serviceType;
import com.example.Software_Advance.models.Tables.Organization;
import com.example.Software_Advance.models.Tables.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface organizationRepository extends JpaRepository<Organization, Long> {

    Optional<Sponsor> findByUserId(Long userId);

    List<Organization> findByServiceType(serviceType serviceType);

}