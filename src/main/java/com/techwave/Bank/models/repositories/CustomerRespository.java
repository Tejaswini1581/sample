package com.techwave.Bank.models.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.techwave.Bank.models.pojo.Customer;
@Repository
public interface CustomerRespository extends CrudRepository<Customer, String>{

	List<Customer> getByStatus(String status);
	Customer getByMailId(String mailId);
	Customer getByPhoneNo(String phoneNo);
}