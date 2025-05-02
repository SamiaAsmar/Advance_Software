package com.example.Software_Advance.DTO;

import com.example.Software_Advance.models.Enums.userRole;
import com.example.Software_Advance.models.Enums.userType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class userDTO {
    private String name;
    private String password;
    private String email;
    private String address;
    private String phone;
    private userType type;
    private userRole role;


}
