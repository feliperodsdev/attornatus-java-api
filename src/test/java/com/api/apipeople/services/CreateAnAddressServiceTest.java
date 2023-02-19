package com.api.apipeople.services;

import com.api.apipeople.entities.Address;
import com.api.apipeople.entities.Person;
import com.api.apipeople.inMemoryDbPerson.AddressInMemoryRepository;
import com.api.apipeople.inMemoryDbPerson.PersonRepositoryinMemory;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CreateAnAddressServiceTest {

    @Test
    public void should_be_able_to_create_an_address(){
        PersonRepositoryinMemory personRepositoryinMemory = new PersonRepositoryinMemory();
        AddressInMemoryRepository addressInMemoryRepository = new AddressInMemoryRepository();
        CreateAnAddressService createAnAddressService = new CreateAnAddressService(addressInMemoryRepository);

        Person person = new Person(null, "Felipe", LocalDate.parse("2002-10-19"));
        personRepositoryinMemory.save(person);

        Address address = new Address(null, "Rua Alvorada", "74473-811", "00", "Goiania");
        address.setPerson(person);

        createAnAddressService.execute(address);

        assertNotNull(address.getId());

    }

}
