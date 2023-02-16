package com.api.apipeople.repositories;

import com.api.apipeople.entities.Person;
import org.springframework.stereotype.Repository;


public interface IPersonRepository {

     public Person save(Person person);

}
