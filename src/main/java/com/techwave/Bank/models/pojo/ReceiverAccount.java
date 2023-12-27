package com.techwave.Bank.models.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ReceiverAccount {
	@Id
	private String account_No;
	private String bankName;
	private String ifscCode;
	private String accountHolderName;

	public ReceiverAccount() {
		super();
	}
	public ReceiverAccount(String account_No, String bankName, String ifscCode, String accountHolderName) {
		super();
		this.account_No = account_No;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
		this.accountHolderName = accountHolderName;
	}

	public String getAccount_No() {
		return account_No;
	}

	public void setAccount_No(String account_No) {
		this.account_No = account_No;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}


}