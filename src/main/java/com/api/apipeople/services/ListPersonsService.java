package com.api.apipeople.services;

import com.api.apipeople.entities.Person;
import com.api.apipeople.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListPersonsService {

    private IPersonRepository personRepository;

    public ListPersonsService(@Qualifier("PersonRepositoryPostgres") IPersonRepository personRepository){this.personRepository = personRepository;}

    public List<Person> execute(){
        return personRepository.listPersons();
    }
}
