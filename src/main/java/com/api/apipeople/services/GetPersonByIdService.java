package com.api.apipeople.services;

import com.api.apipeople.entities.Person;
import com.api.apipeople.repositories.IPersonRepository;
import org.springframework.stereotype.Service;

@Service
public class GetPersonByIdService {

    private IPersonRepository personRepository;

    public GetPersonByIdService(IPersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Person execute(Long id){
        return this.personRepository.getPersonById(id);
    }

}
