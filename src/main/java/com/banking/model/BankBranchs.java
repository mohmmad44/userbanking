package com.banking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class BankBranchs {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name="bank_id")
	private Bank bank;
	
	@OneToOne
	@JoinColumn(name="bank_address_id")
	private BankAddress bankAddress;
	
	
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public BankAddress getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(BankAddress bankAddress) {
		this.bankAddress = bankAddress;
	}
	
	
	
	
	
	
	
	
}
