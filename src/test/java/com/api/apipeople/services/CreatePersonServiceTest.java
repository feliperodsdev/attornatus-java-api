package com.api.apipeople.services;

import com.api.apipeople.entities.Person;
import com.api.apipeople.inMemoryDbPerson.PersonRepositoryinMemory;
import com.api.apipeople.response.HttpResponse;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CreatePersonServiceTest {

    @Test
    public void should_be_able_to_create_an_person() {

        //Person = id, name, dateOfBirth, List<address>
        Person person = new Person(null, "Felipe", LocalDate.parse("2002-10-19"));
        //Create an Service to create an person
        CreatePersonService createPersonService = new CreatePersonService(new PersonRepositoryinMemory());
        createPersonService.execute(person);

        assertNotNull(person.getId());
    }

}
