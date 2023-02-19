package com.api.apipeople.services;

import com.api.apipeople.dtos.UpdatePersonDto;
import com.api.apipeople.entities.Person;
import com.api.apipeople.inMemoryDbPerson.PersonRepositoryinMemory;
import com.api.apipeople.services.exceptions.ResourceNotFound;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class UpdatePersonServiceTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void should_return_updated_person(){
        PersonRepositoryinMemory personRepositoryinMemory = new PersonRepositoryinMemory();
        UpdatePersonService updatePersonService = new UpdatePersonService(personRepositoryinMemory);

        Person p1 = new Person(null, "Felipe", LocalDate.parse("2002-10-19"));
        Person p2 = new Person(null, "Jordana", LocalDate.parse("2003-01-14"));

        personRepositoryinMemory.save(p1);
        personRepositoryinMemory.save(p2);

        Person person = personRepositoryinMemory.getFirstPerson();
        UpdatePersonDto update = new UpdatePersonDto();
        update.setName("Luciana");
        update.setDateOfBirth(LocalDate.parse("2003-01-14"));
        Person personUpdated = updatePersonService.execute(update, person.getId());

        assertEquals(personUpdated.getId(), person.getId());
        assertEquals(personUpdated.getName(), "Luciana");

    }

    @Test
    public void should_throw_resource_exception() {

        exception.expect(ResourceNotFound.class);

        PersonRepositoryinMemory personRepositoryinMemory = new PersonRepositoryinMemory();
        UpdatePersonService updatePersonService = new UpdatePersonService(personRepositoryinMemory);

        Person p1 = new Person(null, "Felipe", LocalDate.parse("2002-10-19"));
        Person p2 = new Person(null, "Jordana", LocalDate.parse("2003-01-14"));

        personRepositoryinMemory.save(p1);
        personRepositoryinMemory.save(p2);

        Person person = personRepositoryinMemory.getFirstPerson();
        UpdatePersonDto update = new UpdatePersonDto();
        update.setName("Luciana");
        update.setDateOfBirth(LocalDate.parse("2003-01-14"));

        updatePersonService.execute(update, person.getId()+1);

    }

}
