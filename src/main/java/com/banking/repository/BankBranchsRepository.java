package com.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banking.model.BankBranchs;


@Repository
public interface BankBranchsRepository extends JpaRepository<BankBranchs, Integer>{

	@Query("select b from BankBranchs as b where b.bank.id = ?1")
	List<BankBranchs> findByBankId(Integer bankId);

	@Query("select a from BankBranchs as a where a.bank.id = ?1 and a.bankAddress.id = ?2")
	BankBranchs getBankBranchId(Integer bankId,  Integer bankAddressId);

}
