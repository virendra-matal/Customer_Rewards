package com.example.customer.rewardservice.beans;

import java.util.Map;


/**
 * DTO representing reward summary response.
 */
public class ResponseData {

	private Long customerId;

	private String customerName;

	private Map<String, Integer> monthlyRewards;

	private Integer totalRewards;

	public Long getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Map<String, Integer> getMonthlyRewards() {
		return monthlyRewards;
	}

	public Integer getTotalRewards() {
		return totalRewards;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setMonthlyRewards(Map<String, Integer> monthlyRewards) {
		this.monthlyRewards = monthlyRewards;
	}

	public void setTotalRewards(Integer totalRewards) {
		this.totalRewards = totalRewards;
	}

	public ResponseData(Long customerId, String customerName, Map<String, Integer> monthlyRewards,
			Integer totalRewards) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.monthlyRewards = monthlyRewards;
		this.totalRewards = totalRewards;
	}

	
}
