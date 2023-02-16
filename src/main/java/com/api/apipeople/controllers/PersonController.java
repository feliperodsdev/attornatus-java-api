package com.api.apipeople.controllers;

import com.api.apipeople.entities.Person;
import com.api.apipeople.repositories.PersonRepository;
import com.api.apipeople.services.CreatePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @PostMapping("/create-person")
    public ResponseEntity<Object> createPerson(@RequestBody Person person){
        CreatePersonService createPersonService = new CreatePersonService(repository);
        return ResponseEntity.status(HttpStatus.CREATED).body(createPersonService.execute(person));
    }

}
