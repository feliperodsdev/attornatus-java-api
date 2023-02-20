package com.api.apipeople.repositories;

import com.api.apipeople.dtos.PersonAddressDto;
import com.api.apipeople.entities.Person;

import java.util.List;
import java.util.Optional;


public interface IPersonRepository {

      Person save(Person person);
      List<Person> listPersons();
      Optional<Person> getPersonById(Long id);

      List<PersonAddressDto> getUserWithPrimaryAddress();

}
