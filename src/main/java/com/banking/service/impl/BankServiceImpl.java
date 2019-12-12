package com.banking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dto.BankBranchsDto;
import com.banking.dto.UserBankBranchsDto;
import com.banking.model.Bank;
import com.banking.model.BankAddress;
import com.banking.model.BankBranchs;
import com.banking.model.User;
import com.banking.model.UserAddress;
import com.banking.model.UserBankBranchs;
import com.banking.repository.BankAddressRepository;
import com.banking.repository.BankBranchsRepository;
import com.banking.repository.BankRepository;
import com.banking.repository.UserAddressRepository;
import com.banking.repository.UserBankBranchsRepository;
import com.banking.repository.UserRepository;
import com.banking.service.BankService;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	BankRepository bankRepository;

	@Autowired
	BankBranchsRepository bankBranchsRepository;

	@Autowired
	BankAddressRepository bankAddressRepository;

	@Autowired
	UserBankBranchsRepository userBankBranchsRepository;

	

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserAddressRepository userAddressRepository;

	@Override
	public List<Bank> getBanks() {
		return bankRepository.findAll();

	}

	@Override
	public Bank saveBanks(Bank bank) {
		return bankRepository.save(bank);
	}

	@Override
	public Bank getBank(Integer id) {
		Optional<Bank> bank = bankRepository.findById(id);
		if (bank.isPresent()) {
			return bank.get();
		}
		return null;
	}

	@Override
	public Bank updateBank(Bank bank) {
		return bankRepository.save(bank);
	}

	@Override
	public void deleteBank(Integer id) {
		bankRepository.deleteById(id);
	}

	@Override
	public List<BankBranchs> getBankBranchs() {
		return (List<BankBranchs>) bankBranchsRepository.findAll();
	}

	@Override
	public void saveBankBranch(BankBranchsDto bankBranch) {

		BankAddress bankAddress = new BankAddress();

		bankAddress.setBankBranch(bankBranch.getBankBranch());
		bankAddress.setBankAddress(bankBranch.getBankAddress());
		bankAddress.setIfscCode(bankBranch.getIfscCode());

		BankAddress dbBankAddress = bankAddressRepository.save(bankAddress);

		if (dbBankAddress != null) {
			BankBranchs bankBranchs = new BankBranchs();

			bankBranchs.setBank(new Bank(bankBranch.getBankId()));
			bankBranchs.setBankAddress(new BankAddress(dbBankAddress.getId()));
			bankBranchsRepository.save(bankBranchs);

		}

	}

	@Override
	public BankAddress updateBankBranch(BankBranchsDto bankBranch) {

		BankAddress bankAddress = new BankAddress();

		bankAddress.setBankBranch(bankBranch.getBankBranch());
		bankAddress.setBankAddress(bankBranch.getBankAddress());
		bankAddress.setIfscCode(bankBranch.getIfscCode());
		bankAddress.setId(bankBranch.getBankAddressId());

		return bankAddressRepository.save(bankAddress);

	}

	@Override
	public BankBranchs getBankBranch(Integer id) {

		Optional<BankBranchs> bankBranchs = bankBranchsRepository.findById(id);

		if (bankBranchs.isPresent()) {
			return bankBranchs.get();
		}
		return null;
	}

	@Override
	public void deleteBankBranch(Integer branchid, Integer addressId) {

		bankBranchsRepository.deleteById(branchid);
		bankAddressRepository.deleteById(addressId);
	}

	@Override
	public List<BankAddress> getBankAddress() {
		return bankAddressRepository.findAll();
	}

	@Override
	public List<UserBankBranchs> getUserBankBranchs() {

		return userBankBranchsRepository.findAll();
	}

	@Override
	public void saveUserBankBranch(UserBankBranchsDto userBankBranchDto) {

		User user = new User();
		user.setFirstName(userBankBranchDto.getFirstName());
		user.setLastName(userBankBranchDto.getLastName());
		user.setEmail(userBankBranchDto.getEmail());
		user.setMobileNumber(userBankBranchDto.getMobileNumber());
		
		User dbUser = userRepository.save(user);
		if(dbUser!=null) {
			UserAddress userAdd = new UserAddress();
			
			userAdd.setHouseNumber(userBankBranchDto.getHouseNumber());
			userAdd.setStreet(userBankBranchDto.getStreet());
			userAdd.setStreetNumber(userBankBranchDto.getStreetNumber());
			userAdd.setCity(userBankBranchDto.getCity());
			userAdd.setPostalCode(userBankBranchDto.getPostalCode());
			userAdd.setUser(dbUser);
			UserAddress dbUserAddress = userAddressRepository.save(userAdd);
			if (dbUserAddress != null) {
				UserBankBranchs userBankBranchs = new UserBankBranchs();
				userBankBranchs.setBankBranchs(bankBranchsRepository.getBankBranchId(userBankBranchDto.getBankId(), userBankBranchDto.getBankAddressId()));
				userBankBranchs.setUser(dbUser);
				userBankBranchsRepository.save(userBankBranchs);
			}
		}



		

		

		
	}

	@Override
	public List<BankBranchs> getbankBranchs(Integer bankId) {
		List<BankBranchs> bankBranchs= bankBranchsRepository.findByBankId(bankId);
		return bankBranchs;
	}

}
