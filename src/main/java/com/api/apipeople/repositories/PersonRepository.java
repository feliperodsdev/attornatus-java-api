package com.api.apipeople.repositories;

import com.api.apipeople.dtos.PersonAddressDto;
import com.api.apipeople.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("PersonRepositoryPostgres")
public class PersonRepository implements IPersonRepository{

    @Autowired
    PersonJPARepository personRepository;

    @Override
    public Person save(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public List<Person> listPersons(){
        return this.personRepository.findAll();
    }

    @Override
    public Optional<Person> getPersonById(Long id){
        return this.personRepository.findById(id);
    }

    @Override
    public List<PersonAddressDto> getUserWithPrimaryAddress() {
        return this.personRepository.getUsersWithPrimaryAddress();
    }

}
