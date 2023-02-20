package com.api.apipeople.repositories;

import com.api.apipeople.entities.Address;

import java.util.Optional;

public interface IAddressRepository {

    Address save(Address address);

    Optional<Address> findById(Long id);

    Address findAddressPrincipal(Long id);

}
