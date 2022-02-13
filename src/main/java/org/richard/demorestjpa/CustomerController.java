package org.richard.demorestjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// work out how to:
// DONE - return a more appropriate http status for deleted/added
// DONE - check if customer exists before add - use email
// DONE - update customer email (PUT)
// - validate input
// - filter / sort
// - search

@RestController
@RequestMapping(path="/api/v1/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	// alternative DI
	/*public CustomerController(CustomerRepository repository) {
		this.repository = repository;
	}*/
	
	@GetMapping
	public ResponseEntity<List<Customer>> allCustomers() {
		return ResponseEntity.ok(service.getAllCustomers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> oneCustomer(@PathVariable Long id) {
		return ResponseEntity.ok(service.getCustomer(id));
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<List<Customer>> findCustomersByEmail(@PathVariable String email) {
		return ResponseEntity.ok(service.getCustomerByEmail(email));
	}
	
	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer c) {
		return new ResponseEntity<>(service.addCustomer(c), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
		return ResponseEntity.ok(service.deleteCustomer(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomerEmail(@PathVariable Long id, @RequestParam String email) {
		return ResponseEntity.ok(service.updateCustomerEmail(id, email));
	}
	

}
