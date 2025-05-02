package com.example.Software_Advance.DTO;

import lombok.Data;

import java.util.List;

@Data
public class donorDTO {
    private userDTO user;
    private List<donationDTO> donations;
}

