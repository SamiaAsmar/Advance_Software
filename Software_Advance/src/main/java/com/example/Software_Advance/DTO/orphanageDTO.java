package com.example.Software_Advance.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Data
public class orphanageDTO {
    private userDTO user;
    private int orphanCount;
    private boolean verified;
        private int capacity;

}

