package org.richard.demorestjpa;

import java.util.List;

interface CustomerService {
	
	Customer addCustomer(Customer c);
	
	Customer deleteCustomer(Long id) throws CustomerNotFoundException;
	
	Customer getCustomer(Long id) throws CustomerNotFoundException;
	
	List<Customer> getCustomerByEmail(String email);
	
	List<Customer> getAllCustomers();

	Customer updateCustomerEmail(Long id, String email);

}
