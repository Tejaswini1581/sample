package com.techwave.Bank.models.pojo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Account {
	@Id
    private String accountNo;
    private String accountName;
    private Double balance;
    
    public Account() {
		super();
	}
	public Account(String accountNo, String accountName, Double balance) {
		super();
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.balance = balance;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
}