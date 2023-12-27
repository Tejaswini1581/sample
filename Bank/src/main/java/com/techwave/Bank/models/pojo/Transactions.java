package com.techwave.Bank.models.pojo;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Transactions {
	@Id
	private String transactionId;
    @ManyToOne
    @JoinColumn(name="accountNo", nullable=false)
	private Account accountNo;
	private String transactionType;
	private Timestamp timestamp;
	private Double amount;
	private String remarks;
	public Transactions() {
		super();
	}
	public Transactions(String transactionId, Account accountNo, String transactionType, Timestamp timestamp,
			Double amount, String remarks) {
		super();
		this.transactionId = transactionId;
		this.accountNo = accountNo;
		this.transactionType = transactionType;
		this.timestamp = timestamp;
		this.amount = amount;
		this.remarks = remarks;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public Account getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Account accountNo) {
		this.accountNo = accountNo;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
