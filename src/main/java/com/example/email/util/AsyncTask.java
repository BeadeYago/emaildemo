package com.example.email.util;

import com.example.email.entity.Person;
import com.example.email.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {


    @Autowired
    private EmailSenderService emailService;

    @Async
    public void testAsync(String email, String name, String lastName, String area) {
        emailService.sendEmail(email, "Los datos han sido guardados.",
                "Buenas, " + name + " " + lastName + " hemos recibido tu inscripcion a la materia: " + area + "." );
    }
}
