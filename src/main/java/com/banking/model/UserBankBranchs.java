package com.banking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserBankBranchs {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer uBankId;
	
	@ManyToOne
	@JoinColumn(name="bank_branchs_id")
	private BankBranchs bankBranchs;
	
	 @ManyToOne
	 @JoinColumn(name="user_id")
	 private User user;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getuBankId() {
		return uBankId;
	}

	public void setuBankId(Integer uBankId) {
		this.uBankId = uBankId;
	}

	public BankBranchs getBankBranchs() {
		return bankBranchs;
	}

	public void setBankBranchs(BankBranchs bankBranchs) {
		this.bankBranchs = bankBranchs;
	}


	
	
	
	
	
}
