package com.api.apipeople.services;

import com.api.apipeople.dtos.PersonAddressDto;
import com.api.apipeople.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListPersonWithPrimaryAddressService {

    private IPersonRepository personRepository;

    public ListPersonWithPrimaryAddressService(@Qualifier("PersonRepositoryPostgres") IPersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<PersonAddressDto> execute(){
        return this.personRepository.getUserWithPrimaryAddress();
    }

}
