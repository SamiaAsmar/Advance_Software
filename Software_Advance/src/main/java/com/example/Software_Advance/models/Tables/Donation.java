package com.example.Software_Advance.models.Tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;

import com.example.Software_Advance.models.Enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "donation")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Donation type is required")
    @Column(name = "donation_type", nullable = false)
    private donationType donationType;

    @Column(name = "organization_id", nullable = true)
    private Long organizationId;

    @NotBlank(message = "Payment type is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type", nullable = false)
    private paymentType paymentType;

    @Column(name = "donation_amount", nullable = true)
    private Double donationAmount;

    @ManyToOne
    @JoinColumn(name = "donor_id", nullable = false)
    @JsonBackReference
    private Donor donor;
}

