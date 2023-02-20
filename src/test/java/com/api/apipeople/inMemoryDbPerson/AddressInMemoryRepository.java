package com.api.apipeople.inMemoryDbPerson;

import com.api.apipeople.entities.Address;
import com.api.apipeople.entities.Person;
import com.api.apipeople.repositories.IAddressRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class AddressInMemoryRepository implements IAddressRepository {

    private List<Address> addresses = new ArrayList<>();

    public Address save(Address address) {
        Random random = new Random();
        address.setId(random.nextLong());
        addresses.add(address);
        return address;
    }

    @Override
    public Optional<Address> findById(Long id) {
        for (Address address : addresses) {
            if (address.getId().equals(id)) {
                return Optional.of(address);
            }
        }
        return Optional.empty();
    }

    public Address getFirst(){
        return this.addresses.get(0);
    }

    @Override
    public Address findAddressPrincipal(Long id) {
        Address addressMarked = null;
        for(Address address: addresses){
            if(address.getPerson().getId() == id){
                addressMarked = address;
            }
        }
        return addressMarked;
    }

}
