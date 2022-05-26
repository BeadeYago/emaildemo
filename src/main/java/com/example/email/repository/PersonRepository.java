package com.example.email.repository;

import com.example.email.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Boolean existsByEmailAndArea(String email, String area);
}
