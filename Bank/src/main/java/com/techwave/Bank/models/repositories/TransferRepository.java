package com.techwave.Bank.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.Bank.models.pojo.Account;
import com.techwave.Bank.models.pojo.Transfer;
@Repository
public interface TransferRepository extends CrudRepository<Transfer,String>{
	List<Transfer> findBySourceAccount(Account accountNo);
}
