package com.api.apipeople.repositories;

import com.api.apipeople.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRepository implements IAddressRepository {

    @Autowired
    AddressJPARepository addressJPARepository;

    @Override
    public Address save(Address address) {
        return this.addressJPARepository.save(address);
    }
}
