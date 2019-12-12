package com.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer>{

}
