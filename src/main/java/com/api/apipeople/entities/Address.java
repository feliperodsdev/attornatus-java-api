package com.api.apipeople.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "tb_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String streetAddress;
    private String zipCode;
    private String number;
    private String city;

    @ManyToOne
    private Person person;

    public Address() {
    }

    public Address(Long id, String streetAddress, String zipCode, String number, String city) {
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
        this.number = number;
        this.city = city;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
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

    @JsonIgnore
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isValidZipCode() {
        return this.zipCode != null && this.zipCode.matches("^\\d{5}-\\d{3}$");
    }

}
