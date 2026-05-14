package com.example.customer.rewardservice.service;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.rewardservice.beans.ResponseData;
import com.example.customer.rewardservice.beans.Transaction;
import com.example.customer.rewardservice.constants.ServiceConstants;
import com.example.customer.rewardservice.dao.TransactionRepository;

/**
 * Implementation class for reward calculation logic.
 */
@Service
public class RewardServiceImpl implements RewardService {

	private static final Logger LOG = LogManager.getFormatterLogger();

	@Autowired
	private TransactionRepository repository;

	
	/**
     * Calculates reward points for all customer transactions.
     *
     * Reward rules:
     * - 2 points for every dollar spent above $100
     * - 1 point for every dollar spent between $50 and $100
     *
     * Rewards are group by month-wise and customer-wise.
     *
     * @return list of reward
     */
	@Override
	public List<ResponseData> calculateCustRewards() {
		Map<Long, ResponseData> rewardsMap = new HashMap<Long, ResponseData>();
		try {
			List<Transaction> transactionsList = this.repository.findAll();
			for (Transaction transaction : transactionsList) {
				Integer points = calculateRewards(transaction.getAmount());

				rewardsMap.putIfAbsent(transaction.getCustomer().getCustomerId(),
						new ResponseData(transaction.getCustomer().getCustomerId(),
								transaction.getCustomer().getCustomerName(), new HashMap<String, Integer>(), 0));

				String monthName = Month.from(transaction.getTransactionDate()).name();
				ResponseData responseData = rewardsMap.get(transaction.getCustomer().getCustomerId());
				responseData.getMonthlyRewards().merge(monthName, points, Integer::sum);
				responseData.setTotalRewards(responseData.getTotalRewards() + points);

				monthName = null;
				responseData = null;
				points = null;
			}

		} catch (Exception e) {
			LOG.error(ServiceConstants.ERROR_OCCURRED_WHILE_CALULATING_CUSTOMER_REWARDS);
			e.printStackTrace();
		}
		return new ArrayList<ResponseData>(rewardsMap.values());
	}

	
	/**
     * Calculates reward points for a single transaction amount.
     *
     * @param amount transaction amount
     * @return calculated reward points
     */
	private Integer calculateRewards(Double amount) {
		try {
			if (amount <= 50) {
				return 0;
			}
			if (amount <= 100) {
				return (int) (amount - 50);
			}
			return 50 + (int) ((amount - 100) * 2);
		} catch (Exception e) {
			LOG.error(ServiceConstants.ERROR_OCCURRED_WHILE_CALULATING_POINTS);
			e.printStackTrace();
			return 0;
		}
	}

}
