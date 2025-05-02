package com.example.Software_Advance.DTO;

import com.example.Software_Advance.models.Enums.Availability;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

@Setter
@Getter
public class volunteerDTO {
    private userDTO user;
    private Long organizationId;
    private String skills;
    private Availability availability;
    private String status;

}

