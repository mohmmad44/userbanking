package com.banking.service;

import java.util.List;

import com.banking.dto.BankBranchsDto;
import com.banking.dto.UserBankBranchsDto;
import com.banking.model.Bank;
import com.banking.model.BankAddress;
import com.banking.model.BankBranchs;
import com.banking.model.UserBankBranchs;


public interface BankService {

	List<Bank> getBanks();

	Bank saveBanks(Bank bank);

	Bank getBank(Integer id);

	Bank updateBank(Bank bank);

	void deleteBank(Integer id);

	List<BankBranchs> getBankBranchs();

	void saveBankBranch(BankBranchsDto bankBranch);

	BankAddress updateBankBranch(BankBranchsDto bankBranch);

	BankBranchs getBankBranch(Integer id);

	void deleteBankBranch(Integer branchid, Integer addressId);

	List<BankAddress> getBankAddress();

	List<UserBankBranchs> getUserBankBranchs();

	void saveUserBankBranch(UserBankBranchsDto userBankBranchDto);

	List<BankBranchs> getbankBranchs(Integer bankId);

	
	
}