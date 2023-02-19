package com.api.apipeople.services;

import com.api.apipeople.entities.Person;
import com.api.apipeople.inMemoryDbPerson.PersonRepositoryinMemory;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class UpdatePersonServiceTest {

    @Test
    public void should_return_updated_person(){
        PersonRepositoryinMemory personRepositoryinMemory = new PersonRepositoryinMemory();
        UpdatePersonService updatePersonService = new UpdatePersonService(personRepositoryinMemory);

        Person p1 = new Person(null, "Felipe", LocalDate.parse("2002-10-19"));
        Person p2 = new Person(null, "Jordana", LocalDate.parse("2003-01-14"));

        personRepositoryinMemory.save(p1);
        personRepositoryinMemory.save(p2);

        Person person = personRepositoryinMemory.getFirstPerson();
        Person update = new Person(null, "Luciana", LocalDate.parse("2002-10-18"));

        Person personUpdated = updatePersonService.execute(update, person.getId());

        assertEquals(personUpdated.getId(), person.getId());
        assertEquals(personUpdated.getName(), "Luciana");

    }

}