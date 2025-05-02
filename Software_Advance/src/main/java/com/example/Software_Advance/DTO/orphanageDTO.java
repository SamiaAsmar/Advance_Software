package com.example.Software_Advance.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class orphanageDTO {
    private userDTO user;
    private int capacity;
    private int orphanCount;
    private boolean verified;
}

