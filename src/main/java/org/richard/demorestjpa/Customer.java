package org.richard.demorestjpa;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "customer")
public class Customer {
	
	private @Id @GeneratedValue Long id;
	private String firstname;
	private String lastname;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dob;
	@Transient
	private Integer age;
	private String email;
	
	public Customer() {}
	
	public Customer(String firstname, String lastname, LocalDate dob, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.email = email;
	}
	
	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return Period.between(dob, LocalDate.now()).getYears();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String toString() {
		return "Customer: " + id + ":" + firstname + ":" + lastname + ":" + this.getAge();
	}

}
