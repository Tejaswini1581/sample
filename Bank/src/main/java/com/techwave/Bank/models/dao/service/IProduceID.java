package com.techwave.Bank.models.dao.service;

import java.util.List;

import com.techwave.Bank.models.pojo.ProduceID;

public interface IProduceID {
	List<ProduceID> getAll();
	ProduceID getByProduceIDId(String idType);
	String insert(ProduceID C);
	String update(Long v, String idType);
	String Delete(String idType);
	String getNextAccountId();
	String getNextTransactionId();
	String getNextTransferId();
}
