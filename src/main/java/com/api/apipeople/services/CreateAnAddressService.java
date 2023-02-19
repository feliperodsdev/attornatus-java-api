package com.api.apipeople.services;

import com.api.apipeople.entities.Address;
import com.api.apipeople.repositories.IAddressRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateAnAddressService {

    private IAddressRepository addressRepository;

    public CreateAnAddressService(IAddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public Address execute(Address address){
        return this.addressRepository.save(address);
    }

}
