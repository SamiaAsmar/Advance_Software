package com.example.Software_Advance.models.Tables;

import com.example.Software_Advance.models.Enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "donor")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @NotBlank(message = "Donation type is required")
    @Column(name = "donation_type", nullable = false)
    private String donationType;

    @Column(name = "organization_id", nullable = true)
    private Long organizationId;

    @NotBlank(message = "Payment type is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type", nullable = false)
    private PaymentType paymentType;


    @Column(name = "donation_amount", nullable = true)
    private Double donationAmount;
}

















