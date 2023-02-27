package com.jbk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jbk.Entity.Address;

public interface AddressDao extends JpaRepository<Address, Integer>{

}
