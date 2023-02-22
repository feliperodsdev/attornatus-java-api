package com.api.apipeople.services;

import com.api.apipeople.entities.Address;
import com.api.apipeople.entities.Person;
import com.api.apipeople.repositories.IAddressRepository;
import com.api.apipeople.services.exceptions.ResourceNotFound;
import com.api.apipeople.services.exceptions.UnauthorizedError;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UpdateAddressToPrincipal {

    private IAddressRepository addressRepository;
    private GetPersonByIdService getPersonByIdService;

    public UpdateAddressToPrincipal(@Qualifier("AddressRepositoryPostgres") IAddressRepository addressRepository, GetPersonByIdService getPersonByIdService){
        this.addressRepository = addressRepository;
        this.getPersonByIdService = getPersonByIdService;
    }

    public void execute(Long idPerson, Long idAddress){
        Person person = getPersonByIdService.execute(idPerson);
        Address address = addressRepository.findById(idAddress).orElseThrow(() -> new ResourceNotFound("Address: " + idAddress));
        if(address.getPerson().getId() != person.getId()) {
            throw new UnauthorizedError("This Address do not belong to this Person");
        }
        Address addressPrincipal = addressRepository.findAddressPrincipal(idPerson);
        if(addressPrincipal != null){
            addressPrincipal.setPrincipal(false);
            addressRepository.save(addressPrincipal);
        }
        address.setPrincipal(true);
        addressRepository.save(address);
    }

}
