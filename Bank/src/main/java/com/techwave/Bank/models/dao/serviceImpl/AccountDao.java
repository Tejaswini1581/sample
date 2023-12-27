package com.techwave.Bank.models.dao.serviceImpl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.Bank.models.dao.service.IAccount;
import com.techwave.Bank.models.pojo.Account;
import com.techwave.Bank.models.repositories.AccountRepository;

@Service
public class AccountDao implements IAccount{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> getAll() {
        return (List<Account>) accountRepository.findAll();
    }
    @Override
    public Account getByAccountId(String accountNo) {
        try {
            Account v = accountRepository.findById(accountNo).get();
            return v;
        } catch (NoSuchElementException E) {
            return null;
        }
    }
    @Override
    public String insert(Account V) {
        accountRepository.save(V);
       return "Inserted";
    }
    @Override
    public String update(Account V, String accountNo) {
        Account old=accountRepository.findById(accountNo).get();
        old.setAccountName(V.getAccountName());
        old.setBalance(V.getBalance());
        accountRepository.save(old);
        return "updated";
    }
    @Override
    public String Delete(String accountNo) {
        Account old=accountRepository.findById(accountNo).get();
        accountRepository.delete(old);
        return "deleted";
    }

}