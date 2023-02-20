package com.api.apipeople.inMemoryDbPerson;

import com.api.apipeople.dtos.PersonAddressDto;
import com.api.apipeople.entities.Address;
import com.api.apipeople.entities.Person;
import com.api.apipeople.repositories.IPersonRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public Optional<Person> getPersonById(Long id) {
        for (Person person : persons) {
            if (person.getId().equals(id)) {
                return Optional.of(person);
            }
        }
        return Optional.empty();
    }

    public List<PersonAddressDto> getUserWithPrimaryAddress() {
        List<PersonAddressDto> list = new ArrayList<>();
        List<Person> persons = this.listPersons();
        for (int i = 0; i< persons.size(); ++i) {
            if(persons.get(i) != null){
                Address address;
                if(persons.get(i).getAllAddress().get(i).getPrincipal()) address = persons.get(i).getAllAddress().get(i);
                else address = null;
                Long id = persons.get(i).getId();
                String name = persons.get(i).getName();
                list.add(new PersonAddressDto(id, name, address));
            }
        }
        return list;
    }

    public Person getFirstPerson(){
        return this.persons.get(0);
    }

}
