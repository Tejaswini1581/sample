package com.techwave.Bank.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.Bank.models.pojo.Account;
import com.techwave.Bank.models.pojo.Transactions;
@Repository
public interface TransactionRepository extends CrudRepository<Transactions, String>{
	List<Transactions> findByAccountNo(Account accountNo);

}
