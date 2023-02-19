package com.api.apipeople.controllers;

import com.api.apipeople.controllers.response.HttpResponse;
import com.api.apipeople.dtos.CreateAddressDto;
import com.api.apipeople.entities.Address;
import com.api.apipeople.repositories.AddressRepository;
import com.api.apipeople.repositories.PersonRepository;
import com.api.apipeople.services.CreateAnAddressService;
import com.api.apipeople.services.GetPersonByIdService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/{person_id}")
    public ResponseEntity<Object> saveAddress(@RequestBody CreateAddressDto createAddressDto, @PathVariable("person_id") Long person_id){
        try {
            CreateAnAddressService createAnAddressService = new CreateAnAddressService(addressRepository);
            GetPersonByIdService getPersonByIdService = new GetPersonByIdService(personRepository);
            HttpResponse response = new HttpResponse();

            String[] requiredFields = {"zipCode", "city", "number", "streetAddress"};

            for (String field : requiredFields) {
                try {
                    Field declaredField = createAddressDto.getClass().getDeclaredField(field);
                    declaredField.setAccessible(true);
                    if (declaredField.get(createAddressDto) == null) {
                        return response.badRequest("Missing Param: " + field);
                    }
                } catch (NoSuchFieldException e) {
                    return new ResponseEntity<>("sei la", HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }

            Address address = new Address();
            BeanUtils.copyProperties(createAddressDto, address);
            address.setPerson(getPersonByIdService.execute(person_id));
            address.setPrincipal(false);

            createAnAddressService.execute(address);

            return response.created("Created");
        }catch (IllegalAccessException e){
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
