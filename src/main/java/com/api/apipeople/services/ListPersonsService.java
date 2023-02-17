package com.api.apipeople.services;

import com.api.apipeople.entities.Person;
import com.api.apipeople.repositories.IPersonRepository;

import java.util.List;

public class ListPersonsService {

    private IPersonRepository personRepository;

    public ListPersonsService(IPersonRepository personRepository){this.personRepository = personRepository;}

    public List<Person> listPersons(){
        return personRepository.listPersons();
    }
}
