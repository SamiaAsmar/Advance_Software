package com.example.Software_Advance.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class donorDTO {
    private userDTO user;
    private List<donationDTO> donations;
}

