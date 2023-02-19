package com.api.apipeople.services;

import com.api.apipeople.dtos.UserAddressDto;

import com.api.apipeople.repositories.IPersonRepository;
import com.api.apipeople.repositories.PersonJPARepository;

import java.util.List;

public class ListPersonWithPrimaryAddressService {

    private IPersonRepository personRepository;

    public ListPersonWithPrimaryAddressService(IPersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<UserAddressDto> execute(){
        return this.personRepository.getUserWithPrimaryAddress();
    }

}
