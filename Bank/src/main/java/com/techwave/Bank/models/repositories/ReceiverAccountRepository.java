package com.techwave.Bank.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.techwave.Bank.models.pojo.ReceiverAccount;
@Repository
public interface ReceiverAccountRepository extends CrudRepository<ReceiverAccount, String>{

	 @Query("SELECT c.accountHolderName FROM ReceiverAccount c WHERE c.accountHolderName LIKE %:partialName%")
	    List<String> findAccountHolderNamesByPartialName(@Param("partialName") String partialName);
}
