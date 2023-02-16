package com.api.apipeople.repositories;

import com.api.apipeople.entities.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository {

     Person save(Person person);

}
