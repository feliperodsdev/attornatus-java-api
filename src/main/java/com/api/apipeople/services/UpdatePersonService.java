package com.api.apipeople.services;

import com.api.apipeople.entities.Person;
import com.api.apipeople.repositories.IPersonRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonService {

    private IPersonRepository personRepository;

    public UpdatePersonService(IPersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Person execute(Person update, Long id){
        Person person = personRepository.getPersonById(id).get();
        updatePerson(update, person);
        return personRepository.save(person);
    }

    private void updatePerson(Person update, Person person){
        person.setName(update.getName());
        person.setDateOfBirth(update.getDateOfBirth());
    }

}