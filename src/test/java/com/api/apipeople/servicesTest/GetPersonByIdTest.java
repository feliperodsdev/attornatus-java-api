package com.api.apipeople.servicesTest;

import com.api.apipeople.entities.Person;
import com.api.apipeople.inMemoryDbPerson.PersonRepositoryinMemory;
import com.api.apipeople.services.GetPersonByIdService;
import com.api.apipeople.services.ListPersonsService;
import com.api.apipeople.services.exceptions.ResourceNotFound;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;

public class GetPersonByIdTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void should_return_an_person() {
        PersonRepositoryinMemory personRepositoryinMemory = new PersonRepositoryinMemory();
        GetPersonByIdService getPersonByIdService = new GetPersonByIdService(personRepositoryinMemory);
        ListPersonsService listPersonsService = new ListPersonsService(personRepositoryinMemory);

        Person p1 = new Person(null, "Felipe", LocalDate.parse("2002-10-19"));
        Person p2 = new Person(null, "Jordana", LocalDate.parse("2003-01-14"));

        personRepositoryinMemory.save(p1);
        personRepositoryinMemory.save(p2);

        List<Person> person = listPersonsService.listPersons();

        assertNotNull(getPersonByIdService.execute(person.get(0).getId()));
        assertNotNull(getPersonByIdService.execute(person.get(1).getId()));
        assertEquals(person.get(0).getName(), "Felipe");
        assertEquals(person.get(1).getName(), "Jordana");
    }

    @Test
    public void should_throw_resource_exception() {

        exception.expect(ResourceNotFound.class);


        PersonRepositoryinMemory personRepositoryinMemory = new PersonRepositoryinMemory();
        GetPersonByIdService getPersonByIdService = new GetPersonByIdService(personRepositoryinMemory);
        ListPersonsService listPersonsService = new ListPersonsService(personRepositoryinMemory);

        Person p1 = new Person(null, "Felipe", LocalDate.parse("2002-10-19"));
        Person p2 = new Person(null, "Jordana", LocalDate.parse("2003-01-14"));

        personRepositoryinMemory.save(p1);
        personRepositoryinMemory.save(p2);

        List<Person> person = listPersonsService.listPersons();

        getPersonByIdService.execute(person.get(0).getId() + person.get(1).getId());

    }

}
