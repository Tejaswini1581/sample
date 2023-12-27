package com.techwave.Bank.models.dao.service;

import java.util.List;

import com.techwave.Bank.models.pojo.Account;
import com.techwave.Bank.models.pojo.Transactions;



public interface ITransaction {
	
	List<Transactions> getAll();
	Transactions getByTransactionsId(String transactionsId);
	String insert(Transactions t);
	String update(Transactions t , String transactionsId);
	String Delete( String transactionsId);
	List<Transactions> findByAccountNo(Account accountNo);
	

}
