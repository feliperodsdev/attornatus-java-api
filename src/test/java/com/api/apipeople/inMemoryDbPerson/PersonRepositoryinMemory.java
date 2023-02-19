package com.api.apipeople.inMemoryDbPerson;

import com.api.apipeople.dtos.UserAddressDto;
import com.api.apipeople.entities.Person;
import com.api.apipeople.repositories.IPersonRepository;
import com.api.apipeople.services.exceptions.ResourceNotFound;
import net.bytebuddy.dynamic.DynamicType;

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

    @Override
    public List<UserAddressDto> getUserWithPrimaryAddress() {
        return null;
    }

    public Person getFirstPerson(){
        return this.persons.get(0);
    }

}
