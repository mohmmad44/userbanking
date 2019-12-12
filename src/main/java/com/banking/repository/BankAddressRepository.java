package com.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.model.BankAddress;


 @Repository
public interface BankAddressRepository extends JpaRepository<BankAddress, Integer> {

}
