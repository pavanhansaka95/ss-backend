package com.example.studentSystem.controller;

import com.example.studentSystem.dto.MailDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/mail")
public class MailController {
    @Autowired
    private JavaMailSender javaMailSender;


    @PostMapping("/send")

    public String sendMail(@RequestBody MailDetailsDTO mailDetailsDTO){
        try {
            SimpleMailMessage message= new SimpleMailMessage();
            message.setSubject(mailDetailsDTO.getSubject());
            message.setTo(mailDetailsDTO.getToMail());
            message.setFrom("pavanhansaka07@gmail.com");
            message.setText(mailDetailsDTO.getMessage());

            javaMailSender.send(message);

            return "Success";

        }catch (Exception e){
            return e.getMessage();
        }


    }
}
