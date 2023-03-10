package com.api.apipeople.repositories;

import com.api.apipeople.dtos.PersonAddressDto;
import com.api.apipeople.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonJPARepository extends JpaRepository<Person, Long> {

    @Query("SELECT new com.api.apipeople.dtos.PersonAddressDto(p.id, p.name, CASE WHEN a.isPrincipal = true THEN a ELSE NULL END) FROM com.api.apipeople.entities.Person p LEFT JOIN p.allAddress a")
    List<PersonAddressDto> getUsersWithPrimaryAddress();

}
