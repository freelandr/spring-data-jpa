package org.richard.demorestjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository repository;

	@Override
	public Customer addCustomer(Customer c) {
		if (repository.findByEmail(c.getEmail()).isEmpty()) {
			return repository.save(c);
		}
		throw new CustomerAlreadyExistsException(c.getEmail());
	}

	@Override
	public Customer deleteCustomer(Long id) throws CustomerNotFoundException {
		Customer c = repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
		repository.deleteById(id);
		return c;
	}

	@Override
	public Customer getCustomer(Long id) throws CustomerNotFoundException {
		return repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
	}
	
	@Override
	public List<Customer> getCustomerByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return repository.findAll();
	}

	@Override
	public Customer updateCustomerEmail(Long id, String email) {
		Customer customer = repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
		customer.setEmail(email);
		return repository.save(customer);
	}
	
	

}
