package com.techwave.Bank.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techwave.Bank.models.bao.Bao;
import com.techwave.Bank.models.pojo.Account;
import com.techwave.Bank.models.pojo.Admin;
import com.techwave.Bank.models.pojo.Customer;
import com.techwave.Bank.models.pojo.ReceiverAccount;
import com.techwave.Bank.models.pojo.Transactions;
import com.techwave.Bank.models.pojo.Transfer;

@CrossOrigin
@RestController
public class restController {

    @Autowired
    Bao bao;

	@GetMapping("/getTransactionsByAccountId/{id}")
	public ResponseEntity<Object> Transactions_getByAccountId(@PathVariable("id") String did) {
        Account id = bao.Account_getByAccountId(did);		
		List<Transactions> A = bao.findByAccountNo(id);
		if (A == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no such element");
		} else {
			return ResponseEntity.of(Optional.of(A));
		}
	}
	@GetMapping("/getTransfersByAccountId/{id}")
	public ResponseEntity<Object> Transfers_getByAccountId(@PathVariable("id") String did) {
        Account id = bao.Account_getByAccountId(did);		
		List<Transfer> A = bao.findTransferByAccountNo(id);
		if (A == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no such element");
		} else {
			return ResponseEntity.of(Optional.of(A));
		}
	}
	@GetMapping("/autocomplete")
	public ResponseEntity<Object> autocomplete(@RequestParam("query") String query) {
		List<String> C = bao.findAccountHolderNamesByPartialName(query);
		if (C == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no Suggestions Found");
		} else {
			return ResponseEntity.of(Optional.of(C));
		}
	}

	@PostMapping("/insertTransaction")
	public ResponseEntity<String> Transactions_save(@RequestBody Transactions A) {
		String s=bao.Transactions_insert(A);
			return ResponseEntity.of(Optional.of(s));
			
	}	
	@PostMapping("/insertTransfer")
	public ResponseEntity<String> Transfer_save(@RequestBody Transfer A) {
		return ResponseEntity.of(Optional.of(bao.Transfer_insert(A)));
		}
	@PostMapping("/insertCustomer")
	public ResponseEntity<String> Customer_save(@RequestBody Customer C) {
		Customer customer = bao.Customer_getByCustomerId(C.getUserId());
		if (customer == null) {
			bao.Customer_insert(C);
			return ResponseEntity.of(Optional.of("Your request has been sent to the Admin.Please wait until Admin accepts your request"));
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("User " +C.getUserId() + " already exist");
		}
	}	
	@GetMapping("/getPendingCustomers")
	public ResponseEntity<Object> Customer_Pending() {
		List<Customer> C = bao.getPendingCustomers();
		if (C == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no Pending Customers Found");
		} else {
			return ResponseEntity.of(Optional.of(C));
		}
	}
	@PutMapping("/updateCustomer/{status}/{id}")
	public ResponseEntity<String> Customer_Statusupdate( @PathVariable("status") String status, @PathVariable("id") String id) {
		Customer customer = bao.Customer_getByCustomerId(id);
		String s = null;
		if (customer != null) {
			s = bao.updateStatus(status, customer);
			return ResponseEntity.of(Optional.of(s));
		}
		return ResponseEntity.of(Optional.of("no row updated"));
	}
	
	
	@GetMapping("/getCustomers")
	public ResponseEntity<List<Customer>> Customer_getAll() {
		List<Customer> lst = bao.Customer_getAll();
		return ResponseEntity.of(Optional.of(lst));
	}
	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<Object> Customer_getByRegId(@PathVariable String id) {
		Customer C = bao.Customer_getByCustomerId(id);
		if (C == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no such element");
		} else {
			return ResponseEntity.of(Optional.of(C));
		}
	}
	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<String> Customer_update(@RequestBody Customer C, @PathVariable("id") String id) {
		Customer customer = bao.Customer_getByCustomerId(C.getUserId());
		String s = null;
		if (customer != null) {
			s = bao.Customer_update(customer, id);
			return ResponseEntity.of(Optional.of(s));
		}
		return ResponseEntity.of(Optional.of("no row updated"));
	}
	///deletemapping
    
    
    
    
    
    
    
    
    
    @GetMapping("/getAccounts")
    public ResponseEntity<List<Account>> Account_getAll() {
        List<Account> list = bao.Account_getAll();
        return ResponseEntity.of(Optional.of(list));
    }
    @GetMapping("/getAccount/{id}")
    public ResponseEntity<Object>  Account_getByAccountId(@PathVariable("id") String id) {
        Account v = bao.Account_getByAccountId(id);
        if (v == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no such element");
        } else {
            return ResponseEntity.of(Optional.of(v));
        }
    }
    @PostMapping("/insertAccount")
    public ResponseEntity<String> Account_insert(@RequestBody Account v) {
        Account account = bao.Account_getByAccountId(v.getAccountNo());
        if (account == null) {
            bao.Account_insert(v);
            return ResponseEntity.of(Optional.of("1 row inserted"));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Account with " + v.getAccountNo() + " already exist");
        }
    }
    @PutMapping("/updateAccount/{id}")
    public ResponseEntity<String> Account_update(@RequestBody Account v, @PathVariable("id") String id) {
        Account account = bao.Account_getByAccountId(id);
        String s = null;
        if (account != null) {
            s = bao.Account_update(v, id);
            return ResponseEntity.of(Optional.of(s));
        }
        return ResponseEntity.of(Optional.of("no account updated"));
    }
    @DeleteMapping("/deleteAccount/{id}")
    public ResponseEntity<String> Account_delete(@PathVariable("id") String id) {
        Account account = bao.Account_getByAccountId(id);
        if (account != null) {
            String s = bao.Account_Delete(id);
            return ResponseEntity.of(Optional.of(s));
        }
        return ResponseEntity.of(Optional.of("no account deleted"));
    }
    
    
    
    
    
    

	@GetMapping("/getAdmins")
	public ResponseEntity<List<Admin>> Admin_getAll() {
		List<Admin> lst = bao.Admin_getAll();
		return ResponseEntity.of(Optional.of(lst));
	}
	@GetMapping("/getAdmin/{id}")
	public ResponseEntity<Object> Admin_getByRegId(@PathVariable String id) {
		Admin A = bao.Admin_getByAdminId(id);
		if (A == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no such element");
		} else {
			return ResponseEntity.of(Optional.of(A));
		}
	}
	@PostMapping("/insertAdmin")
	public ResponseEntity<String> Admin_save(@RequestBody Admin A) {

		Admin admin = bao.Admin_getByAdminId(A.getAdminId());
		if (admin == null) {
			bao.Admin_insert(A);
			return ResponseEntity.of(Optional.of("1 row inserted"));
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Admin " + A.getAdminId() + " already exist");
		}
	}
	@PutMapping("/updateAdmin/{id}")
	public ResponseEntity<String> Admin_update(@RequestBody Admin A, @PathVariable("id") String id) {
		Admin admin = bao.Admin_getByAdminId(A.getAdminId());
		String s = null;
		if (admin != null) {
			s = bao.Admin_update(A, id);
			return ResponseEntity.of(Optional.of(s));
		}
		return ResponseEntity.of(Optional.of("no row updated"));	
	}	
	@DeleteMapping("/deleteAdmin/{id}")
	public ResponseEntity<String> Admin_delete(@PathVariable("id") String id) {
		Admin admin = bao.Admin_getByAdminId(id);
		String s = null;
		if (admin != null) {
			s = bao.Admin_Delete(id);
			return ResponseEntity.of(Optional.of(s));
		}
		return ResponseEntity.of(Optional.of("no row updated"));
	}


    
    
	
	
	
	@GetMapping("/getReceiverAccount")
	public ResponseEntity<List<ReceiverAccount>> ReceiverAccount_getAll() {
		List<ReceiverAccount> lst = bao.ReceiverAccount_getAll();
		return ResponseEntity.of(Optional.of(lst));
	}
	@GetMapping("/getReceiverAccount/{id}")
	public ResponseEntity<Object> ReceiverAccount_getByRegId(@PathVariable String id) {
		ReceiverAccount A = bao.ReceiverAccount_getByReceiverAccountId(id);
		if (A == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no such element");
		} else {
			return ResponseEntity.of(Optional.of(A));
		}
	}
	@PostMapping("/insertReceiverAccount")
	public ResponseEntity<String> ReceiverAccount_save(@RequestBody ReceiverAccount A) {
		ReceiverAccount ReceiverAccount = bao.ReceiverAccount_getByReceiverAccountId(A.getAccount_No());
		if (ReceiverAccount == null) {
			bao.ReceiverAccount_insert(A);
			return ResponseEntity.of(Optional.of("1 row inserted"));
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Account_No " + A.getAccount_No() + " already exist");
		}
	}
	@PutMapping("/updateReceiverAccount/{id}")
	public ResponseEntity<String> ReceiverAccount_update(@RequestBody ReceiverAccount A, @PathVariable("id") String id) {
		ReceiverAccount ReceiverAccount = bao.ReceiverAccount_getByReceiverAccountId(A.getAccount_No());
		String s = null;
		if (ReceiverAccount != null) {
			s = bao.ReceiverAccount_update(A, id);
			return ResponseEntity.of(Optional.of(s));
		}
		return ResponseEntity.of(Optional.of("no row updated"));
	}
	@DeleteMapping("/deleteReceiverAccount/{id}")
	public ResponseEntity<String> ReceiverAccount_delete(@PathVariable("id") String id) {
		ReceiverAccount ReceiverAccount = bao.ReceiverAccount_getByReceiverAccountId(id);
		String s = null;
		if (ReceiverAccount != null) {
			s = bao.ReceiverAccount_Delete(id);
			return ResponseEntity.of(Optional.of(s));
		}
		return ResponseEntity.of(Optional.of("no row updated"));
	}
	
	
	
	
	@GetMapping("/getTransactions")
	public ResponseEntity<List<Transactions>> Transactions_getAll() {
		List<Transactions> lst = bao.Transactions_getAll();
		return ResponseEntity.of(Optional.of(lst));
	}
	@GetMapping("/getTransaction/{id}")
	public ResponseEntity<Object> Transactions_getByRegId(@PathVariable String id) {
		Transactions A = bao.Transactions_getByTransactionsId(id);
		if (A == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no such element");
		} else {
			return ResponseEntity.of(Optional.of(A));
		}
	}
	@PutMapping("/updateTransaction/{id}")
	public ResponseEntity<String> Transactions_update(@RequestBody Transactions A, @PathVariable("id") String id) {
		Transactions Transactions = bao.Transactions_getByTransactionsId(A.getTransactionId());
		String s = null;
		if (Transactions != null) {
			s = bao.Transactions_update(A, id);
			return ResponseEntity.of(Optional.of(s));
		}
		return ResponseEntity.of(Optional.of("no row updated"));
	}
	@DeleteMapping("/deleteTransaction/{id}")
	public ResponseEntity<String> Transactions_delete(@PathVariable("id") String id) {
		Transactions Transactions = bao.Transactions_getByTransactionsId(id);
		String s = null;
		if (Transactions != null) {
			s = bao.Transactions_Delete(id);
			return ResponseEntity.of(Optional.of(s));
		}
		return ResponseEntity.of(Optional.of("no row updated"));
	}

	
	
	@GetMapping("/getTransfers")
	public ResponseEntity<List<Transfer>> Transfer_getAll() {
		List<Transfer> lst =bao.Transfer_getAll();
		return ResponseEntity.of(Optional.of(lst));
	}
	@GetMapping("/getTransfer/{id}")
	public ResponseEntity<Object> Transfer_getByRegId(@PathVariable String id) {
		Transfer A =bao.Transfer_getByTransferId(id);
		if (A == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no such element");
		} else {
			return ResponseEntity.of(Optional.of(A));
		}
	}
	@PutMapping("/UpdateTransfer/{id}")
	public ResponseEntity<String> Transfer_update(@RequestBody Transfer A, @PathVariable("id") String id) {
		Transfer transfer =bao.Transfer_getByTransferId(A.getTransferId());
		String s = null;
		if (transfer != null) {
			s =bao.Transfer_update(A, id);
			return ResponseEntity.of(Optional.of(s));
		}
		return ResponseEntity.of(Optional.of("no row updated"));
	}
	@DeleteMapping("/deleteTransfer/{id}") 
	public ResponseEntity<String> Transfer_delete(@PathVariable("id") String id) {
		Transfer transfer =bao.Transfer_getByTransferId(id);
		String s = null;
		if (transfer != null) {
			s =bao.Transfer_Delete(id);
			return ResponseEntity.of(Optional.of(s));
		}
		return ResponseEntity.of(Optional.of("no row updated"));
	}
	
	
	

}