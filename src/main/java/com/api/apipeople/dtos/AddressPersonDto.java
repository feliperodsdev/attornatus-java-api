package com.api.apipeople.dtos;

public class AddressPersonDto {

    private String zipCode;
    private String number;
    private String city;
    private String streetAddress;

    public AddressPersonDto(String zipCode, String number, String city, String streetAddress) {
        this.zipCode = zipCode;
        this.number = number;
        this.city = city;
        this.streetAddress = streetAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
}
