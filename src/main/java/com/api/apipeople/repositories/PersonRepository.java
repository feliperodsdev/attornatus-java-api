package com.api.apipeople.repositories;

import com.api.apipeople.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class PersonRepository implements IPersonRepository{

    @Autowired
    PersonJPARepository personJPARepository;

    @Override
    public Person save(Person person) {
        return this.personJPARepository.save(person);
    }

}
