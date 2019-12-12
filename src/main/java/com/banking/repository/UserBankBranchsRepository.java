package com.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.model.UserBankBranchs;

public interface UserBankBranchsRepository extends JpaRepository<UserBankBranchs, Integer> {
	

}
