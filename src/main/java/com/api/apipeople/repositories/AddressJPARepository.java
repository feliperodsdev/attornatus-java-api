package com.api.apipeople.repositories;

import com.api.apipeople.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressJPARepository extends JpaRepository<Address, Long> {

    @Query("SELECT a FROM Address a WHERE a.person.id = :id AND a.isPrincipal = true")
    Address findAddressPrincipal(Long id);

}
