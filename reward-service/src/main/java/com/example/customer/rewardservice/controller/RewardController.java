package com.example.customer.rewardservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.rewardservice.beans.ResponseData;
import com.example.customer.rewardservice.constants.ServiceConstants;
import com.example.customer.rewardservice.service.RewardServiceImpl;

/**
 * REST controller for customer rewards operations.
 * Provides APIs to calculate and fetch reward points.
 */
@RestController
public class RewardController {
	
	private static final Logger LOG = LogManager.getFormatterLogger();
	
	@Autowired
	private RewardServiceImpl rewardServiceImpl;

	/**
	 * Basically, this method will handle the get 
	 * customer rewards and return the total as well as monthly rewards.
	 * 
	 * @return List<ResponseData> that hold basicallym monthly rewards of customer, total Rewards, customer Id and name
	 */
	@GetMapping("/api/customer/rewards")
    public List<ResponseData> getCustomerRewards() {
        try {
        	return rewardServiceImpl.calculateCustRewards();
		} catch (Exception e) {
			LOG.error(ServiceConstants.ERROR_OCCURRED_IN_THE_CONTROLLER);
			e.printStackTrace();
			return new ArrayList<ResponseData>();
		}
    }
}
