package com.example.customer.rewardservice.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity representing customer details.
 */
@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
    private Long customerId;

	@Column(name = "CustomerName")
    private String customerName;
	
	@Column(name = "CustomerNumber")
	private String customerNumber;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public Customer(Long customerId, String customerName, String customerNumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerNumber = customerNumber;
	}
	
}
