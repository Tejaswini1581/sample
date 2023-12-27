package com.techwave.Bank.models.dao.serviceImpl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.Bank.models.dao.service.IReceiverAccount;
import com.techwave.Bank.models.pojo.ReceiverAccount;
import com.techwave.Bank.models.repositories.ReceiverAccountRepository;


@Service
public class ReceiverAccountDao implements IReceiverAccount{

    @Autowired
    ReceiverAccountRepository receiverAccountRepository;

    @Override

    public ReceiverAccount findByAccountHolderName(String accountHolderName,String bank) {
        return receiverAccountRepository.findByAccountHolderNameAndBankName(accountHolderName, bank);
    }
    @Override  //dao
    public List<ReceiverAccount> getAll(String name) {
        return (List<ReceiverAccount>) receiverAccountRepository.findByAccountHolderNameStartsWith(name);
    }
    @Override
    public List<ReceiverAccount> getAll() {
        return (List<ReceiverAccount>) receiverAccountRepository.findAll();
    }
    @Override
    public ReceiverAccount getByReceiverAccountId(String ReceiverAccountNo) {
        try {
            ReceiverAccount v = receiverAccountRepository.findById(ReceiverAccountNo).get();
            return v;
        } catch (NoSuchElementException E) {
            return null;
        }
    }
    @Override
    public String insert(ReceiverAccount V) {
        receiverAccountRepository.save(V);
       return "Inserted";
    }
    @Override
    public String update(ReceiverAccount V, String ReceiverAccountNo) {
        ReceiverAccount old=receiverAccountRepository.findById(ReceiverAccountNo).get();
        old.setAccountHolderName(V.getAccountHolderName());
        old.setBankName(V.getBankName());
        old.setIfscCode(V.getIfscCode());
        receiverAccountRepository.save(old);
        return "updated";
    }
    @Override
    public String Delete(String ReceiverAccountNo) {
        ReceiverAccount old=receiverAccountRepository.findById(ReceiverAccountNo).get();
        receiverAccountRepository.delete(old);
        return "deleted";
    }
	@Override
	public List<String> findAccountHolderNamesByPartialName(String partialName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ReceiverAccount> ListAll(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}