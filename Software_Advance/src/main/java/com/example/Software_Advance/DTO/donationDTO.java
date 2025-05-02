package com.example.Software_Advance.DTO;

import com.example.Software_Advance.models.Enums.donationType;
import com.example.Software_Advance.models.Enums.paymentType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class donationDTO {
    private donationType donationType;
    private Long organizationId;
    private paymentType paymentType;
    private Double donationAmount;
}

