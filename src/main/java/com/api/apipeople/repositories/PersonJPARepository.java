package com.api.apipeople.repositories;

import com.api.apipeople.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJPARepository extends JpaRepository<Person, Long> {
}
