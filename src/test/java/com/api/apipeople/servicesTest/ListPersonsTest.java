package com.api.apipeople.servicesTest;

import com.api.apipeople.entities.Person;
import com.api.apipeople.inMemoryDbPerson.PersonRepositoryinMemory;
import com.api.apipeople.services.ListPersonsService;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;

public class ListPersonsTest {

    @Test
    public void should_return_an_listof_persons(){

        PersonRepositoryinMemory personRepositoryinMemory = new PersonRepositoryinMemory();
        ListPersonsService listPersonsService = new ListPersonsService(personRepositoryinMemory);

        Person p1 = new Person(null, "Felipe", LocalDate.parse("2002-10-19"));
        Person p2 = new Person(null, "Jordana", LocalDate.parse("2003-01-14"));

        personRepositoryinMemory.save(p1);
        personRepositoryinMemory.save(p2);

        List<Person> listPersons = listPersonsService.execute();

        assertEquals("Felipe", listPersons.get(0).getName());
        assertEquals("Jordana", listPersons.get(1).getName());
    }

}
