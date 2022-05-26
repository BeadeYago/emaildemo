package com.example.email.controller;

import com.example.email.entity.Person;
import com.example.email.exception.BusinessException;
import com.example.email.service.EmailSenderService;
import com.example.email.service.PersonService;
import com.example.email.util.AsyncTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/api")
public class PersonController {

    Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService service;

    @Autowired
    private AsyncTask asyncTask;

    @GetMapping("/persons")
    public ResponseEntity<?> findAll() {
        List<Person> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/persons")
    public ResponseEntity<?> save(@Valid @RequestBody Person person) {
        boolean exist = service.existsByEmailAndArea(person.getEmail(), person.getArea());

        if (!exist) {
            logger.info("The user has been created.");
        //    asyncTask.testAsync(person.getEmail(), person.getName(), person.getLastName(), person.getArea());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(person));
        } else {
            logger.error("The user tries to register two times to the same area.");
            throw new BusinessException("P-500", HttpStatus.BAD_REQUEST, "La persona con el email: " +
                    person.getEmail() + " ya esta asignada a la materia " + person.getArea()+ ".");
        }
    }
}
