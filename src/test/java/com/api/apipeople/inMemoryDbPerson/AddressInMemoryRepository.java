package com.api.apipeople.inMemoryDbPerson;

import com.api.apipeople.entities.Address;
import com.api.apipeople.repositories.IAddressRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddressInMemoryRepository implements IAddressRepository {

    private List<Address> addresses = new ArrayList<>();

    public Address save(Address address) {
        Random random = new Random();
        address.setId(random.nextLong());
        addresses.add(address);
        return address;
    }

}
