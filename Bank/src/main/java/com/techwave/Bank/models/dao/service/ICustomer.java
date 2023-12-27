package com.techwave.Bank.models.dao.service;

import java.util.List;
import com.techwave.Bank.models.pojo.Customer;

public interface ICustomer {
	List<Customer> getAll();
	List<Customer> getPendingCustomers();
	String updateStatus(String C, Customer customer);
	Customer getByCustomerId(String customrId);
	String insert(Customer C);
	String update(Customer C, String customerId);
	String Delete(String customerId);
}