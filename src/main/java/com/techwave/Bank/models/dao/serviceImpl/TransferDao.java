package com.techwave.Bank.models.dao.serviceImpl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.Bank.models.dao.service.ITransfer;
import com.techwave.Bank.models.pojo.Account;
import com.techwave.Bank.models.pojo.Transfer;
import com.techwave.Bank.models.repositories.TransferRepository;
@Service
public class TransferDao implements ITransfer{

    @Autowired
    TransferRepository transferRepository;

    @Override
    public List<Transfer> getAll() {
        return (List<Transfer>) transferRepository.findAll();
    }
    @Override
    public Transfer getByTransferId(String TransferNo) {
        try {
            Transfer v = transferRepository.findById(TransferNo).get();
            return v;
        } catch (NoSuchElementException E) {
            return null;
        }
    }
    @Override
    public String insert(Transfer V) {
    	Transfer q= transferRepository.save(V);
       return q.toString();
    }
    @Override
    public String update(Transfer V, String TransferNo) {
        Transfer old=transferRepository.findById(TransferNo).get();
        old.setAmount(V.getAmount());
        old.setDestinationAccountName(V.getDestinationAccountName());
        old.setRemarks(V.getRemarks());
        old.setSourceAccount(V.getSourceAccount());
        old.setTimeStamp(V.getTimeStamp());
        old.setTransferType(V.getTransferType());
        transferRepository.save(old);
        return "updated";
    }
    @Override
    public String Delete(String TransferNo) {
        Transfer old=transferRepository.findById(TransferNo).get();
        transferRepository.delete(old);
        return "deleted";
    }
	@Override
	public List<Transfer> findByAccountNo(Account accountNo) {
		return transferRepository.findBySourceAccount(accountNo);
	}

}