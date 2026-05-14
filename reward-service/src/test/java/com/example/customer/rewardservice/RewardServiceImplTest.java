package com.example.customer.rewardservice;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.customer.rewardservice.beans.Customer;
import com.example.customer.rewardservice.beans.Transaction;
import com.example.customer.rewardservice.dao.TransactionRepository;
import com.example.customer.rewardservice.service.RewardServiceImpl;

public class RewardServiceImplTest {

	@Test
    void testRewardCalculation() {

        Customer customer = new Customer(1L, "John", "3764247998");

        Transaction transaction =
                new Transaction(
                        1L,
                        120.0,
                        LocalDate.now(),
                        customer);

        TransactionRepository repository =
                Mockito.mock(TransactionRepository.class);

        Mockito.when(repository.findAll())
				.thenReturn(Arrays.asList(transaction));
        

        RewardServiceImpl service =
                new RewardServiceImpl();

        int total =
                service.calculateCustRewards()
                        .get(0)
                        .getTotalRewards();

        assertEquals(90, total);
    }

}
