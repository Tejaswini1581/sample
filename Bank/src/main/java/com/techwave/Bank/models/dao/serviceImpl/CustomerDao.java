package com.techwave.Bank.models.dao.serviceImpl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.Bank.models.dao.service.ICustomer;
import com.techwave.Bank.models.pojo.Customer;

import com.techwave.Bank.models.repositories.CustomerRespository;
@Service
public class CustomerDao implements ICustomer{

    @Autowired
    CustomerRespository customerRepository;


	@Override
	public List<Customer> getPendingCustomers() {
		return customerRepository.getByStatus("Pending");
		
	}
	@Override
	public String updateStatus(String C, Customer old) {
        old.setStatus(C);
        customerRepository.save(old);
        return "updated";
	}
    @Override
    public List<Customer> getAll() {
        return (List<Customer>) customerRepository.findAll();
    }
    @Override
    public Customer getByCustomerId(String CustomerNo) {
        try {
            Customer v = customerRepository.findById(CustomerNo).get();
            return v;
        } catch (NoSuchElementException E) {
            return null;
        }
    }
    @Override
    public String insert(Customer V) {
    	V.setStatus("Pending");
        customerRepository.save(V);
       return "Inserted";
    }
    @Override
    public String update(Customer V, String CustomerNo) {
        Customer old=customerRepository.findById(CustomerNo).get();
        old.setFirstName(V.getFirstName());
        old.setLastName(V.getLastName());
        old.setMailId(V.getMailId());
        old.setPhoneNo(V.getPhoneNo());
        old.setDateOfBirth(V.getDateOfBirth());
        old.setAccountNo(V.getAccountNo());
        old.setAddress(V.getAddress());
        old.setGender(V.getGender());
        old.setStatus(V.getStatus());
        old.setPassword(V.getPassword());
        customerRepository.save(old);
        return "updated";
    }
    @Override
    public String Delete(String CustomerNo) {
        Customer old=customerRepository.findById(CustomerNo).get();
        customerRepository.delete(old);
        return "deleted";
    }

}