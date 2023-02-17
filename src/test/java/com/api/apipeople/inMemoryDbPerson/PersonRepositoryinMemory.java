package com.api.apipeople.inMemoryDbPerson;

import com.api.apipeople.entities.Person;
import com.api.apipeople.repositories.IPersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonRepositoryinMemory implements IPersonRepository {

    private List<Person> persons = new ArrayList<>();

    public Person save(Person person){
        Random random = new Random();
        person.setId(random.nextLong());
        persons.add(person);
        return person;
    }

    public List<Person> listPersons(){
        return persons;
    }

}
