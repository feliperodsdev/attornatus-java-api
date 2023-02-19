package com.api.apipeople.repositories;

import com.api.apipeople.dtos.UserAddressDto;
import com.api.apipeople.entities.Address;
import com.api.apipeople.entities.Person;

import java.util.List;
import java.util.Optional;


public interface IPersonRepository {

     public Person save(Person person);
     public List<Person> listPersons();
     public Optional<Person> getPersonById(Long id);

     public List<UserAddressDto> getUserWithPrimaryAddress();

}
