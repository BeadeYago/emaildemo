package com.example.email.service;

import com.example.email.entity.Person;
import com.example.email.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repo;

    public boolean existsByEmailAndArea(String email, String area){
        return repo.existsByEmailAndArea(email, area);
    }

    public Person save(Person person){
        return repo.save(person);
    }

    public List<Person> findAll(){
        return repo.findAll();
    }
}
