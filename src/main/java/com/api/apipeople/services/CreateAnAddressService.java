package com.api.apipeople.services;

import com.api.apipeople.entities.Address;
import com.api.apipeople.repositories.IAddressRepository;
import com.api.apipeople.services.exceptions.EntitieValidationException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CreateAnAddressService {

    private IAddressRepository addressRepository;

    public CreateAnAddressService(@Qualifier("AddressRepositoryPostgres") IAddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public Address execute(Address address){

        if(!address.isValidZipCode()){
            throw new EntitieValidationException("Zip code invalid!");
        }

        return this.addressRepository.save(address);
    }

}
