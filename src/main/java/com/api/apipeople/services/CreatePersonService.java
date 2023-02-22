package com.api.apipeople.services;

import com.api.apipeople.entities.Person;
import com.api.apipeople.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonService {

    private IPersonRepository personRepository;

    public CreatePersonService(@Qualifier("PersonRepositoryPostgres") IPersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Person execute(Person person){
        Person createdPerson = personRepository.save(person);
        return createdPerson;
    }

}
