package com.api.apipeople.servicesTest;

import com.api.apipeople.entities.Address;
import com.api.apipeople.entities.Person;
import com.api.apipeople.inMemoryDbPerson.AddressInMemoryRepository;
import com.api.apipeople.inMemoryDbPerson.PersonRepositoryinMemory;
import com.api.apipeople.services.GetPersonByIdService;
import com.api.apipeople.services.UpdateAddressToPrincipal;
import com.api.apipeople.services.exceptions.ResourceNotFound;

import com.api.apipeople.services.exceptions.UnauthorizedError;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class UpdateAddressToPrincipalTest {

    @Test
    public void should_update_an_address(){
        PersonRepositoryinMemory personRepository = new PersonRepositoryinMemory();
        GetPersonByIdService getPersonByIdService = new GetPersonByIdService(personRepository);
        AddressInMemoryRepository addressRepository = new AddressInMemoryRepository();
        UpdateAddressToPrincipal updateAddressToPrincipal = new UpdateAddressToPrincipal(addressRepository, getPersonByIdService);

        Person person = new Person(null, "Felipe", LocalDate.parse("2002-10-19"));
        personRepository.save(person);

        Address address = new Address(null, "Rua Alvorada", "74473-811", "00", "Goiania");
        address.setPerson(person);

        addressRepository.save(address);

        updateAddressToPrincipal.execute(personRepository.getFirstPerson().getId(), addressRepository.getFirst().getId());

        Address updatedAddressFromRepository = addressRepository.findById(address.getId()).get();
        assertEquals(address, updatedAddressFromRepository);

    }

    @Test
    public void should_throw_an_error_user_not_found(){


        PersonRepositoryinMemory personRepository = new PersonRepositoryinMemory();
        GetPersonByIdService getPersonByIdService = new GetPersonByIdService(personRepository);
        AddressInMemoryRepository addressRepository = new AddressInMemoryRepository();
        UpdateAddressToPrincipal updateAddressToPrincipal = new UpdateAddressToPrincipal(addressRepository, getPersonByIdService);

        Person person = new Person(null, "Felipe", LocalDate.parse("2002-10-19"));
        personRepository.save(person);

        Address address = new Address(null, "Rua Alvorada", "74473-811", "00", "Goiania");
        address.setPerson(person);

        addressRepository.save(address);

        assertThrows(ResourceNotFound.class, () -> {
            updateAddressToPrincipal.execute(null, addressRepository.getFirst().getId());
        });

    }

    @Test
    public void should_throw_an_error_address_not_found(){

        PersonRepositoryinMemory personRepository = new PersonRepositoryinMemory();
        GetPersonByIdService getPersonByIdService = new GetPersonByIdService(personRepository);
        AddressInMemoryRepository addressRepository = new AddressInMemoryRepository();
        UpdateAddressToPrincipal updateAddressToPrincipal = new UpdateAddressToPrincipal(addressRepository, getPersonByIdService);

        Person person = new Person(null, "Felipe", LocalDate.parse("2002-10-19"));
        personRepository.save(person);

        Address address = new Address(null, "Rua Alvorada", "74473-811", "00", "Goiania");
        address.setPerson(person);

        addressRepository.save(address);

        assertThrows(ResourceNotFound.class, () -> {
            updateAddressToPrincipal.execute(personRepository.getFirstPerson().getId(), addressRepository.getFirst().getId()+1);
        });

        addressRepository.findById(address.getId()).get();
    }

    @Test
    public void should_throw_an_error_unauthorized(){

        PersonRepositoryinMemory personRepository = new PersonRepositoryinMemory();
        GetPersonByIdService getPersonByIdService = new GetPersonByIdService(personRepository);
        AddressInMemoryRepository addressRepository = new AddressInMemoryRepository();
        UpdateAddressToPrincipal updateAddressToPrincipal = new UpdateAddressToPrincipal(addressRepository, getPersonByIdService);

        Person person = new Person(null, "Felipe", LocalDate.parse("2002-10-19"));
        personRepository.save(person);

        Person person2 = new Person(null, "Felipe", LocalDate.parse("2002-10-19"));
        personRepository.save(person);

        Address address = new Address(null, "Rua Alvorada", "74473-811", "00", "Goiania");
        address.setPerson(person2);

        addressRepository.save(address);

        assertThrows(UnauthorizedError.class, () -> {
            updateAddressToPrincipal.execute(personRepository.getFirstPerson().getId(), addressRepository.getFirst().getId());
        });

        addressRepository.findById(address.getId()).get();
    }

}
