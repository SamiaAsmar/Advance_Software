package com.example.Software_Advance.DTO;

import lombok.Data;

@Data
public class CreateUserRequestDTO {
    private userDTO user;
    private donorDTO donor;
    private sponsorDTO sponsor;
    private volunteerDTO volunteer;
    private organizationDTO organization;
    private orphanageDTO orphanage;
}
