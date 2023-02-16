package com.api.apipeople.inMemoryDbPerson;

import com.api.apipeople.entities.Person;
import com.api.apipeople.repositories.IPersonRepository;

import java.util.Random;

public class PersonRepositoryinMemory implements IPersonRepository {

    public Person save(Person person){
        Random random = new Random();
        person.setId(random.nextLong());
        return person;
    }

}
