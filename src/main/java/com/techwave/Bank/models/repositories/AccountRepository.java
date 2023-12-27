package com.techwave.Bank.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.Bank.models.pojo.Account;
@Repository
public interface AccountRepository  extends CrudRepository<Account, String>{
	List<Account> findByAccountName(String name);
}
