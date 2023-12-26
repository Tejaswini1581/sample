package com.techwave.Bank.models.dao.serviceImpl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.Bank.models.dao.service.ITransaction;
import com.techwave.Bank.models.pojo.Account;
import com.techwave.Bank.models.pojo.Transactions;
import com.techwave.Bank.models.repositories.TransactionRepository;


@Service
public class TransactionDao implements ITransaction{

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transactions> getAll() {
        return (List<Transactions>) transactionRepository.findAll();
    }
    @Override
    public Transactions getByTransactionsId(String TransactionNo) {
        try {
            Transactions v = transactionRepository.findById(TransactionNo).get();
            return v;
        } catch (NoSuchElementException E) {
            return null;
        }
    }
    @Override
    public String insert(Transactions V) {
        transactionRepository.save(V);
       return "Inserted";
    }
    @Override
    public String update(Transactions V, String TransactionNo) {
        Transactions old=transactionRepository.findById(TransactionNo).get();
        old.setTransactionType(V.getTransactionType());
        old.setAmount(V.getAmount());
        old.setRemarks(V.getRemarks());
        old.setTimestamp(V.getTimestamp());
        old.setAccountNo(V.getAccountNo());
        transactionRepository.save(old);
        return "updated";
    }
    @Override
    public String Delete(String TransactionNo) {
        Transactions old=transactionRepository.findById(TransactionNo).get();
        transactionRepository.delete(old);
        return "deleted";
    }
	@Override
	public List<Transactions> findByAccountNo(Account accountNo) {
		return transactionRepository.findByAccountNo(accountNo);
	}

}