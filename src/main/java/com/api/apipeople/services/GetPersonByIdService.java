package com.api.apipeople.services;

import com.api.apipeople.entities.Person;
import com.api.apipeople.repositories.IPersonRepository;
import com.api.apipeople.services.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetPersonByIdService {

    private IPersonRepository personRepository;

    public GetPersonByIdService(@Qualifier("PersonRepositoryPostgres") IPersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Person execute(Long id){
        Optional<Person> person = this.personRepository.getPersonById(id);
        return person.orElseThrow(() -> new ResourceNotFound(id));
    }

}
