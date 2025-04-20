/*package com.example.Software_Advance.models.Tables;

import com.example.Software_Advance.models.Enums.DonationStatus;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "type_of_donations")
public class TypeOfDonation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "campaign_id", nullable = false)
    private ReliefCampaign campaign;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date donationDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DonationStatus status;
}*/