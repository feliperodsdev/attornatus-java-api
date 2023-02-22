package com.api.apipeople.repositories;

import com.api.apipeople.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("AddressRepositoryPostgres")
public class AddressRepository implements IAddressRepository {

    @Autowired
    AddressJPARepository addressRepository;

    @Override
    public Address save(Address address) {
        return this.addressRepository.save(address);
    }

    @Override
    public Optional<Address> findById(Long id) {
        return this.addressRepository.findById(id);
    }

    @Override
    public Address findAddressPrincipal(Long id) {
        return this.addressRepository.findAddressPrincipal(id);
    }
}
