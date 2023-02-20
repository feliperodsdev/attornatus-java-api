package com.api.apipeople.services;

import com.api.apipeople.dtos.PersonAddressDto;
import com.api.apipeople.repositories.IPersonRepository;

import java.util.List;

public class ListPersonWithPrimaryAddressService {

    private IPersonRepository personRepository;

    public ListPersonWithPrimaryAddressService(IPersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<PersonAddressDto> execute(){
        return this.personRepository.getUserWithPrimaryAddress();
    }

}
