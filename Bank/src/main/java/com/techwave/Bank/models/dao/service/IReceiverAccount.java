package com.techwave.Bank.models.dao.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.techwave.Bank.models.pojo.ReceiverAccount;



public interface IReceiverAccount {
	
	List<ReceiverAccount> getAll();
	ReceiverAccount getByReceiverAccountId(String receiverAccountId);
	String insert(ReceiverAccount r);
	String update(ReceiverAccount v , String receiverAccountId);
	String Delete( String receiverAccountId);
	List<String> findAccountHolderNamesByPartialName(String partialName);

}
