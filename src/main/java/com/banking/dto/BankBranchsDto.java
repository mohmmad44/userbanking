package com.banking.dto;

public class BankBranchsDto {
	
	
	private Integer bankId;
	private Integer bankAddressId;
	private String bankAddress;
	private String bankBranch;
	private String ifscCode;
	
	
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public Integer getBankAddressId() {
		return bankAddressId;
	}
	public void setBankAddressId(Integer bankAddressId) {
		this.bankAddressId = bankAddressId;
	}
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

}
