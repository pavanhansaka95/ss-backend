package com.example.studentSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailDetailsDTO {
    private String toMail;
//    private String message;
//    private String subject;

    String message = "Your data correct";
    String subject ="Donot reply";

}
