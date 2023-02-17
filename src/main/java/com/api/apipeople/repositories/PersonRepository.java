package com.api.apipeople.repositories;

import com.api.apipeople.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class PersonRepository implements IPersonRepository{

    @Autowired
    PersonJPARepository personJPARepository;

    @Override
    public Person save(Person person) {
        return this.personJPARepository.save(person);
    }

    @Override
    public List<Person> listPersons(){
        return this.personJPARepository.findAll();
    }

}
