package com.techwave.Bank.models.dao.service;

import java.util.List;
import com.techwave.Bank.models.pojo.Account;


public interface IAccount {
	List<Account> getAll();
	Account getByAccountId(String accountId);
	List<Account> getByAccountName(String accountId);
	String insert(Account a);
	String update(Account a , String  accountId);
	String Delete( String  accountId);
	
	
}
