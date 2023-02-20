package com.api.apipeople.dtos;

import com.api.apipeople.entities.Address;

public class PersonAddressDto {
    private Long id;
    private String name;
    private AddressPersonDto primaryAddress;

    public PersonAddressDto(Long id, String name, Address primaryAddress) {
        this.id = id;
        this.name = name;
        this.setPrimaryAddress(primaryAddress);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressPersonDto getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        if(primaryAddress != null) {
            AddressPersonDto addressPersonDto = new AddressPersonDto(primaryAddress.getZipCode(), primaryAddress.getNumber(), primaryAddress.getCity(), primaryAddress.getStreetAddress());
            this.primaryAddress = addressPersonDto;
        }
        else this.primaryAddress = null;
    }
}
