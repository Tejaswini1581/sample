package com.techwave.Bank.models.dao.service;

import java.util.List;

import com.techwave.Bank.models.pojo.Account;
import com.techwave.Bank.models.pojo.Transfer;


public interface ITransfer {
	List<Transfer> getAll();
	Transfer getByTransferId(String transferId);
	String insert(Transfer a);
	String update(Transfer a , String  transferId);
	String Delete( String  transferId);
	List<Transfer> findByAccountNo(Account accountNo);
	
}
