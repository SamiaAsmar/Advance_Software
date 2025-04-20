package com.example.Software_Advance.DTO;


import lombok.Data;

@Data
public class orphanageDTO {
    private userDTO user;
    private int capacity;
    private int orphanCount;
    private boolean verified;
}

