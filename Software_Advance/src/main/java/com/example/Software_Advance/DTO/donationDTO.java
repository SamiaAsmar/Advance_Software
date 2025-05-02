package com.example.Software_Advance.DTO;

import com.example.Software_Advance.models.Enums.donationType;
import com.example.Software_Advance.models.Enums.paymentType;
import lombok.Data;

@Data
public class donationDTO {
    private donationType donationType;
    private Long organizationId;
    private paymentType paymentType;
    private Double donationAmount;
    public donationDTO(donationType donationType, Double donationAmount) {
        this.donationType = donationType;
        this.donationAmount = donationAmount;
    }
    public donationDTO(donationType donationType, Double donationAmount, Long organizationId, paymentType paymentType) {
        this.donationType = donationType;
        this.donationAmount = donationAmount;
        this.organizationId = organizationId;
        this.paymentType = paymentType;
    }

}