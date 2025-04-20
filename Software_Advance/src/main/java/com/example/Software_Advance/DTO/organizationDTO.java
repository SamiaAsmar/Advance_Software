package com.example.Software_Advance.DTO;


import com.example.Software_Advance.models.Enums.serviceType;
import lombok.Data;

@Data
public class organizationDTO {
    private userDTO user;
    private serviceType serviceType;
}
