package com.api.apipeople.controllers;

import com.api.apipeople.dtos.CreatePersonDto;
import com.api.apipeople.dtos.PersonAddressDto;
import com.api.apipeople.dtos.UpdatePersonDto;
import com.api.apipeople.entities.Person;
import com.api.apipeople.repositories.PersonRepository;
import com.api.apipeople.controllers.response.HttpResponse;
import com.api.apipeople.services.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;

@RestController
@RequestMapping()
public class PersonController {

    @Autowired
    private CreatePersonService createPersonService;

    @Autowired
    private ListPersonsService listPersonsService;

    @Autowired
    private ListPersonWithPrimaryAddressService listPersonWithPrimaryAddressService;

    @Autowired
    private GetPersonByIdService getPersonByIdService;

    @Autowired
    private UpdatePersonService updatePersonService;

    @PostMapping("/create-person")
    public ResponseEntity<Object> createPerson(@RequestBody CreatePersonDto createPersonDto) {
        HttpResponse response = new HttpResponse();
        try {
            String[] requiredFields = {"name", "dateOfBirth"};

            for (String field : requiredFields) {
                try {
                    Field declaredField = createPersonDto.getClass().getDeclaredField(field);
                    declaredField.setAccessible(true);
                    if (declaredField.get(createPersonDto) == null) {
                        return response.badRequest("Missing Param: " + field);
                    }
                } catch (NoSuchFieldException e) {
                    return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
                }catch (IllegalAccessException e) {
                    return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
            Person person = new Person();
            BeanUtils.copyProperties(createPersonDto, person);
            createPersonService.execute(person);
            return response.created("Person Created");
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/persons-address")
    public ResponseEntity<Object> getPersonsWithPrimaryAddress() {
        try {
        HttpResponse response = new HttpResponse();
            List<PersonAddressDto> listPersons = listPersonWithPrimaryAddressService.execute();
            return response.ok(listPersons);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/persons")
    public ResponseEntity<Object> getPersons() {
        try {
            HttpResponse response = new HttpResponse();
            List<Person> listPersons = listPersonsService.execute();
            return response.ok(listPersons);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Object> getPerson(@PathVariable("id") Long id) {
        HttpResponse response = new HttpResponse();
        Person person = getPersonByIdService.execute(id);
        return response.ok(person);
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Object> updatePerson(@PathVariable("id") Long id, @RequestBody UpdatePersonDto update) {
                HttpResponse response = new HttpResponse();

                String[] requiredFields = {"name", "dateOfBirth"};

                for (String field : requiredFields) {
                    try {
                        Field declaredField = update.getClass().getDeclaredField(field);
                        declaredField.setAccessible(true);
                        if (declaredField.get(update) == null) {
                            return response.badRequest("Missing Param: " + field);
                        }
                    } catch (NoSuchFieldException e) {
                        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
                    } catch (IllegalAccessException e) {
                        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
                    }
                }
                updatePersonService.execute(update, id);
                return response.ok("Updated");
    }
}