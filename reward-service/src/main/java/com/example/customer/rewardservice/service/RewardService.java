package com.example.customer.rewardservice.service;

import java.util.List;

import com.example.customer.rewardservice.beans.ResponseData;

/**
 * Service interface for reward calculations.
 */
public interface RewardService {
	
	/**
     * Calculate reward points for all customers.
     *
     * Rewards are grouped by:
     * - customer
     * - monthly rewards
     * - total reward points
     *
     * @return list of reward response DTOs
     */
	List<ResponseData> calculateCustRewards();

}
