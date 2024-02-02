package com.example.studentSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class StudentDTO {
    private int stuID;
    private String stuFirstName;
    private String stuLastName;
    private String stuAddress;
    private String stuNumber;
    private String stuEmail;

}
