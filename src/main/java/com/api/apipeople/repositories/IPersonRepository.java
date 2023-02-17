package com.api.apipeople.repositories;

import com.api.apipeople.entities.Person;

import java.util.List;


public interface IPersonRepository {

     public Person save(Person person);
     public List<Person> listPersons();
     public Person getPersonById(Long id);

}
