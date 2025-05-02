package com.example.Software_Advance.DTO;

import com.example.Software_Advance.models.Enums.sponsorshipType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class sponsorDTO {
    private userDTO user;
    private sponsorshipType sponsorshipType;
    private LocalDate startDate;
    private String status;
}

