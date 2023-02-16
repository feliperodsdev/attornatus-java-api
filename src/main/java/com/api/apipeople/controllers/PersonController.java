package com.api.apipeople.controllers;

import com.api.apipeople.dtos.CreatePersonDto;
import com.api.apipeople.entities.Person;
import com.api.apipeople.repositories.PersonRepository;
import com.api.apipeople.controllers.response.HttpResponse;
import com.api.apipeople.services.CreatePersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;

@RestController
@RequestMapping()
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @PostMapping("/create-person")
    public ResponseEntity<Object> createPerson(@RequestBody CreatePersonDto createPersonDto){
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
                }
            }
            CreatePersonService createPersonService = new CreatePersonService(repository);
            Person person = new Person();
            BeanUtils.copyProperties(createPersonDto, person);
            createPersonService.execute(person);
            return response.created("Person Created");
        }catch(Exception e){
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
