package com.example.Software_Advance.repositories;

import com.example.Software_Advance.models.Enums.donationType;
import com.example.Software_Advance.models.Tables.Donation;
import com.example.Software_Advance.models.Enums.paymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface donationRepository extends JpaRepository<Donation, Long> {

    List<Donation> findByDonationType(donationType donationType);

    List<Donation> findByPaymentType(paymentType paymentType);

    List<Donation> findByOrganizationId(Long organizationId);

    List<Donation> findByDonorId(Long donorId);

    List<Donation> findByDonationAmountGreaterThanEqual(Double amount);
}
