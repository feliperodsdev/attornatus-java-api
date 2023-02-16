package com.api.apipeople.repositories;

import com.api.apipeople.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PersonJPARepository extends JpaRepository<Person, Long> {
}
