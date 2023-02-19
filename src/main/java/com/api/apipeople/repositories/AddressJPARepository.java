package com.api.apipeople.repositories;

import com.api.apipeople.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressJPARepository extends JpaRepository<Address, Long> {
}
